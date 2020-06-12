FROM clojure:openjdk-11-lein-2.9.1 as builder

RUN mkdir -p /app

WORKDIR /app


COPY project.clj ./project.clj

RUN lein deps

COPY resources ./resources
COPY src ./src

RUN env LEIN_SNAPSHOTS_IN_RELEASE=1 \
    lein uberjar && \
  cp ./target/uberjar/graleph-standalone.jar ./graleph.jar


FROM docker.pkg.github.com/graalvm/container/community:latest as compiler

RUN mkdir -p /app
RUN gu install native-image

WORKDIR /app

COPY --from=builder /app/graleph.jar .

COPY reflect.json ./reflect.json
COPY ./script/compile /app/compile

RUN /app/compile


FROM debian:buster-slim


RUN mkdir -p /opt
WORKDIR /opt

COPY --from=compiler /app/graleph /opt/graleph

CMD /opt/graleph
