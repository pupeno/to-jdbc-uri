;;;; Copyright © 2015 Carousel Apps, Ltd

(ns to-jdbc-uri.core)

(defn- postgresql-to-jdbc-uri [uri]
  (let [[username password] (if (.getUserInfo uri)
                              (clojure.string/split (.getUserInfo uri) #":")
                              [nil nil])
        query-pairs (clojure.string/join "&" (remove nil? [(if username (str "user=" username))
                                                           (if password (str "password=" password))]))
        query-string (if (not= "" query-pairs)
                       (str "?" query-pairs))
        port (if (not= -1 (.getPort uri))
               (.getPort uri))
        host-and-port (clojure.string/join ":" (remove nil? [(.getHost uri) port]))]
    (str "jdbc:postgresql://" host-and-port (.getPath uri) query-string)))

(defn to-jdbc-uri
  "Convert a non-JDBC URI to a JDBC one."
  [uri]
  (if (.startsWith uri "jdbc")
    uri
    (let [parsed-uri (java.net.URI. uri)]
      (case (.getScheme parsed-uri)
        "postgres" (postgresql-to-jdbc-uri parsed-uri)
        (throw (Exception. (str "Unsupported URI: " uri " please, submit an issue request and we'll try to add it. Pull requests also welcome")))))))


