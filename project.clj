(defproject questionnaire "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [bidi "2.1.4"]
                 [http-kit "2.2.0"]
                 [ring/ring-core "1.6.3"]]
  
  :main ^:skip-aot questionnaire.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
