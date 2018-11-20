;; (println ((fn [x y & more] (cond (> x y) x :else y)) 1 8 3 4))
(fn [x y & more] (cond (> x y) x :else y))
