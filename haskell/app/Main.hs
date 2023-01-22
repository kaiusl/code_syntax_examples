module Main where

import Data.Either (fromLeft, fromRight)
import qualified MyLib (someFunc)

-- comment
{- comment -}

n = 4

n1 = 2.5

n2 :: Float
n2 = 2.5

numFromStr = read "2.5" :: Float

n4 = let a' = 1 in a' + 1

s1 = "abc"

s2 = 'a'

b1 = True || False && 5 /= 3

aOrB =
  if sq 5 > 7
    then "a"
    else "b"

arr = [1] ++ [2, 3]

arr2 = 1 : [2, 3]

arr3 = [1 .. 3]

arr4 = [x | x <- [1 .. 3], odd x]

isFirstElemEq = arr !! 1 == arr2 !! 1

head_ = head arr

tuple = (1, 2, "str")

sq :: Integral x => x -> x
sq x
  | x == 1 = 1
  | x == 2 = 4
  | otherwise = x * x

sq' :: Integral x => x -> x
sq' x = case x of
  1 -> 1
  2 -> 4
  x -> x * x

sq'' = \x -> x * x

sq2 x = sq s where s = sq x

sq2' x = (sq . sq) x

sq2'' x = sq $ sq x

sum' :: (Num b) => [b] -> b
sum' [] = error "no elements"
sum' all@(head : tail) = head + sum' tail

class SomeClass a where
  class_func :: a -> a

data Letter = A String | B deriving (Show)

instance SomeClass Letter where
  class_func x = x

type LetterAlias = Letter

data SomeData a = SomeData
  { value :: a
  }

newtype Data2 a = Data2
  { value2 :: a
  }

letter = A "asf"

letter2 = B

data2 = Data2 "a"

-- main :: IO ()
main = do
  putStrLn "Hello, Haskell!"
  MyLib.someFunc
  putStrLn ""