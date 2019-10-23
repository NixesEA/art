package com.nixes.server

import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerRequest

fun main(args: Array<String>) {
    Vertx.vertx().deployVerticle(NetClientVerticle())
}

class NetClientVerticle : AbstractVerticle() {
    override fun start() {
        // Create an HTTP server which simply returns "Hello World!" to each request.
        vertx.createHttpServer()
            .requestHandler { req: HttpServerRequest ->
                req.response().end("Hello World!")
            }.listen(8080)
    }
}