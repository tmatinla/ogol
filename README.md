# Ogol

Ogol is an interactive environment for playing with ClojureScript and
Processing.js made for Clojure Cup 2013.

You can use it online here: http://ogol.clojurecup.com

## Technologies used

* ClojureScript compilation (REPL) is provided by Himera
* Processing.js (wrapped with Libre)
* jQuery (wrapped with jayq), jQuery UI, jQuery console

## Prerequisites

You will need [Leiningen][1] installed.

[1]: https://github.com/technomancy/leiningen

## Running

To compile ClojureScript, run:

    lein cljsbuild once

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2013 Tero Matinlassi
