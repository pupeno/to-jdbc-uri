[![Clojars Project](http://clojars.org/to-jdbc-uri/latest-version.svg)](http://clojars.org/to-jdbc-uri)

# to-jdbc-uri

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

    [to-jdbc-uri "0.1.0"]

and then call it like this:

    (to-jdbc-uri.core/to-jdbc-uri your-non-jdbc-url)

for example:

    (to-jdbc-uri.core/to-jdbc-uri "jdbc:postgresql://hostname:3306/dbname?user=username&password=password")

For more examples, you might want to look into the tests, which are very simple.

## License

Copyright © 2015 Carousel Apps

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
