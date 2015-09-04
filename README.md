# to-jdbc-uri

[![Build Status](https://travis-ci.org/carouselapps/to-jdbc-uri.svg?branch=master)](https://travis-ci.org/carouselapps/to-jdbc-uri)

Many libraries starting with clojure.java.jdbc and libraries that use
[clojure.java.jdbc](https://github.com/clojure/java.jdbc) internally expect a JDBC URI to connect to the database, but
your environment might be giving you the database specs in a different format. This library is designed to take the
database credentials in any format and, as long as it's possible, generate a valid JDBC URI. Currently supported:

- PostgreSQL (Heroku and others)
- MySQL

Support for other formats, databases, environments is welcome.

The code in this library is actually trivial but if you need to perform this task and search for solutions you'll find
lots of different snippets of code, some which work in some environments and not others. Even if you end up not using
this library but copying and pasting
[the code](https://github.com/carouselapps/to-jdbc-uri/blob/master/src/to_jdbc_uri/core.clj) it is better to have a
canonical place for this code to exist.

## Usage

In your project.clj include the dependency:

[![Clojars Project](http://clojars.org/to-jdbc-uri/latest-version.svg)](http://clojars.org/to-jdbc-uri)

and then call it like this:

    (to-jdbc-uri.core/to-jdbc-uri your-non-jdbc-url)

for example:

    (to-jdbc-uri "postgres://username:password@hostname/dbname")

which will output:

    "jdbc:postgresql://hostname/dbname?user=username&password=password"

It is safe to feed JDBC URIs to this library, they'll be left untouched. For more examples, you might want to look into
[the tests](https://github.com/carouselapps/to-jdbc-uri/blob/master/test/to_jdbc_uri/core_test.clj), which are very
simple.

## Contributing

To contribute:

1. fork the project
2. Add support for your favorite database/environment/format
3. Add tests for the new code you wrote
4. Make sure all tests pass, new and all
5. Push, commit and send a pull request. Note how urgently you need a new release.

## Change log

### v0.3.0 - 2015-08-24
- Added support for MySQL.

### v0.2.0 - 2015-06-20
- Raise an exception when the URI is empty or blank.
- Started using Travis CI for continuous integration.

### v0.1.0 - 2015-06-15
- Initial version supporting PostgreSQL (at least on Heroku).

## License

Copyright © 2015 Carousel Apps, Ltd. All rights reserved.

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
