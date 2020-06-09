Attempt at building a statsd-like server in aleph, and compile it with graalvm


## Building

1. Auth with GitHub's Docker repo. GitHub doesn't support anonymous `pull`s so there's some setup involved
   - get a personal token with `package:read` scope
   - run `docker login docker.pkg.github.com` and provide your GH username and the token

2. `docker build . -t graleph:latest`

3. Test it:


```shell
# Terminal 1

docker run --net host --rm graleph:latest
```

and then

```shell
Terminal 2

./script/gen-metrics
```
