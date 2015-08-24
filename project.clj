;;;; Copyright © 2015 Carousel Apps, Ltd

(defproject to-jdbc-uri "0.3.0-SNAPSHOT"
  :description "Simple function to convert non-JDBC URIs into JDBC ones"
  :url "https://github.com/carouselapps/to-jdbc-uri"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :lein-release {:deploy-via :clojars}
  :signing {:gpg-key "F2FB1C6F"}
  :dependencies [[org.clojure/clojure "1.6.0"]])
