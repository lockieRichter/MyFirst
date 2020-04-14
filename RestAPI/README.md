# sumsquares
Basic Spring REST API

This REST API will run at localhost:8081 and accepts a POST request containing an array of numeric inputs. This array must contain at least three elements.

The API will then find the three highest numbers, compute the square root of the sum of the squares of these numbers and return this value, rounded to two decimal places.

## Example
A POST request with the following data:
{
  “data”: [5,4,6,1]
}
would produce the following return:
{
  "output": 8.77
}
