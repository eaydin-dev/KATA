(ns digitizer.core)
  
(defn digitize [num]
  "https://www.codewars.com/kata/5583090cbe83f4fd8c000051/"
  (map {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9} (reverse (str num))))
