# to-jdbc-uri

[![Build Status](https://travis-ci.org/carouselapps/to-jdbc-uri.svg?branch=master)](https://travis-ci.org/carouselapps/to-jdbc-uri)

I notice that many templates and libraries out there expect a JDBC URI to connect to the database, but sometimes, that's
not what you have. Sometimes what you have is the native URI of the database, like in the popular case of Heroku that
gives you a PostgreSQL database. If you look for solutions to this problem you'll find lots of different code snippets
that build a JDBC URI out of a PostgreSQL one, most with bugs and limitations. This little library intends to the
solution to that.

It's a very trivial library, so if you don't want to pull it into your project, you can copy and paste the function(s)
that you want. It's still better to have a canonical solution to this problem than hundreds of little snippets floating
around.

At the moment, this library is far for complete. It just deals with the PostgreSQL URIs Heroku gives you. In all other
cases it'll throw an exception. For those cases, please, create an issue or a pull request and over time this library
will grow to be the canonical way to get JDBC URIs.

## Usage

In your project.clj include the dependency:

[![Clojars Project](http://clojars.org/to-jdbc-uri/latest-version.svg)](http://clojars.org/to-jdbc-uri)

and then call it like this:

    (to-jdbc-uri.core/to-jdbc-uri your-non-jdbc-url)

for example:

    (to-jdbc-uri.core/to-jdbc-uri "jdbc:postgresql://hostname:3306/dbname?user=username&password=password")

For more examples, you might want to look into the tests, which are very simple.

## Changelog

### v0.3.0 - 2015-08-24
- Added support for MySQL.

### v0.2.0 - 2015-06-20
- Raise an exception when the URI is empty or blank.
- Started using Travis CI for continuous integration.

### v0.1.0 - 2015-06-15
- Initial version supporting PostgreSQL (at least on Heroku).

## License

Copyright © 2015 Carousel Apps

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
