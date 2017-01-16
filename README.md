# play-cookie-issue

/ok is handled with `Ok.discardingCookies(DiscardingCookie("test"))`.

    $ curl -v localhost:9000/ok
    > GET /ok HTTP/1.1
    > User-Agent: curl/7.35.0
    > Host: localhost:9000
    > Accept: */*
    >
    < HTTP/1.1 200 OK
    < Set-Cookie: test=; Max-Age=-86400; Expires=Sun, 15 Jan 2017 20:16:18 GMT; Path=/; HTTPOnly
    < Content-Length: 0
    < Date: Mon, 16 Jan 2017 20:16:18 GMT
    <

Notice `Max-Age=-86400`.

/bad is handled with `Ok.discardingCookies(DiscardingCookie("test")).withCookies(Cookie("other", "value"))`.

    $ curl -v localhost:9000/bad
    > GET /bad HTTP/1.1
    > User-Agent: curl/7.35.0
    > Host: localhost:9000
    > Accept: */*
    >
    < HTTP/1.1 200 OK
    < Set-Cookie: test=; Max-Age=0; Expires=Mon, 16 Jan 2017 20:17:13 GMT; Path=/; HTTPOnly
    < Set-Cookie: other=value; Path=/; HTTPOnly
    < Content-Length: 0
    < Date: Mon, 16 Jan 2017 20:17:13 GMT
    <

Notice `Max-Age=0`.

See: https://github.com/lucidsoftware/play-cookie-issue/blob/master/app/Controller.scala
