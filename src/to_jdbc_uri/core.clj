;;;; Copyright © 2015 Carousel Apps, Ltd

(ns to-jdbc-uri.core
  (:require [clojure.string :as s]))

(defn- format-credentials [user-info]
  (when user-info
    (let [[username password] (s/split user-info #":")
          user-and-pass
          (->> [(when username (str "user=" username))
                (when password (str "password=" password))]
               (remove nil?)
               (s/join "&")
               (not-empty))]
      (when-not (empty? user-and-pass)
        (str "?" user-and-pass)))))

(defn- port [port]
  (when-not (neg? port)
    port))

(defn- host-and-port [host port]
  (s/join ":" (remove nil? [host (port port)])))

(defn- postgresql-to-jdbc-uri [uri]
  (str "jdbc:postgresql://"
       (host-and-port (.getHost uri) (.getPort uri))
       (.getPath uri)
       (format-credentials (.getUserInfo uri))))

(defn to-jdbc-uri
  "Convert a non-JDBC URI to a JDBC one."
  [uri]
  (when (empty? uri)
    (throw (Exception. "URI connection string cannot be empty!")))
  (if (.startsWith uri "jdbc")
    uri
    (let [parsed-uri (java.net.URI. uri)]
      (case (.getScheme parsed-uri)
        "postgres" (postgresql-to-jdbc-uri parsed-uri)
        (throw (Exception. (str "Unsupported URI: " uri " please, submit an issue request and we'll try to add it. Pull requests also welcome")))))))
