(defn ensure-float [num]
  (if (integer? num)
    (float num)
    num))

(defn parse-number [str]
  (if-let [num (read-string str)]
    (if (number? num)
      num
      (throw (ex-info "Invalid number" {})))
    (throw (ex-info "Invalid number" {}))))

(defn main []
  (println "Enter the first number: ")
  (let [num1-string (read-line)
        num1 (ensure-float (parse-number num1-string))]
    (println "Choose between:")
    (println "1) Addition")
    (println "2) Subtraction")
    (println "3) Multiplication")
    (println "4) Division")
    (print ": ")
    (let [calculation-type (Integer/parseInt (read-line))]
      (println "Enter the second number: ")
      (let [num2-string (read-line)
            num2 (ensure-float (parse-number num2-string))
            result (case calculation-type
                     1 (+ num1 num2)
                     2 (- num1 num2)
                     3 (* num1 num2)
                     4 (/ num1 num2)
                     (throw (ex-info "Invalid calculation type." {})))]
        (println "The result is:" result)))))

(main)
