;;(false? (__ '(1 2 3 4 5)))
;;(true? (__ "racecar"))
(fn [x] (= (seq x) (reverse x)))
