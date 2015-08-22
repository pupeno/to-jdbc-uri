;;;; Copyright © 2015 Carousel Apps, Ltd

(ns to-jdbc-uri.core-test
  (:require [clojure.test :refer :all]
            [to-jdbc-uri.core :refer :all]))

(deftest to-jdbc-uri-test
  (testing "Already JDBC URIs are left alone"
    (is (= (to-jdbc-uri "jdbc:postgresql://hostname:3306/dbname?user=username&password=password")
           "jdbc:postgresql://hostname:3306/dbname?user=username&password=password")))
  (testing "Heroku-like PostgreSQL URI"                     ;; I think this is actually a generic PostgreSQL URL and not Heroku specific.
    (is (= (to-jdbc-uri "postgres://username:password@hostname/dbname")
           "jdbc:postgresql://hostname/dbname?user=username&password=password")))
  (testing "Heroku-like PostgreSQL URI without username and password"
    (is (= (to-jdbc-uri "postgres://hostname:1234/dbname")
           "jdbc:postgresql://hostname:1234/dbname")))
  (testing "Heroku-like PostgreSQL URI with port and username; no password"
    (is (= (to-jdbc-uri "postgres://username@hostname:1234/dbname")
           "jdbc:postgresql://hostname:1234/dbname?user=username")))
  (testing "Heroku-like PostgreSQL URI with port, username and password"
    (is (= (to-jdbc-uri "postgres://username:password@hostname:1234/dbname")
           "jdbc:postgresql://hostname:1234/dbname?user=username&password=password")))
  (testing "Heroku-like MySQL URI with port, username and password"
    (is (= (to-jdbc-uri "mysql://username:password@hostname:1234/dbname")
           "jdbc:mysql://hostname:1234/dbname?user=username&password=password")))
  (testing "Empty uri raises excetion"
    (is (thrown? Exception (to-jdbc-uri "")))
    (is (thrown? Exception (to-jdbc-uri nil)))))
