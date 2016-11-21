/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2016/11/14.
 */

import com.github.bingoohuang.spockdemo.User

def user = new User()
user.firstName = "John"
user.lastName = "Doe"

print(user.firstName)

// the simplest closure
def hello = {"Hello, $it!"}
assert hello('Chris') == 'Hello, Chris!'

// the closure that do not take any params
def bye = {->'Bye!'}
assert bye() == 'Bye!'

// the closure with several params
def niceHello = {firstName, lastName -> "Hello, $firstName $lastName!"}
assert niceHello('Chris', 'Bennett') == 'Hello, Chris Bennett!'

def list = ['One', 'Two', 'Three']

// gets the first element from the list
assert list[0] == 'One'

// gets a range of elements from the list
assert list[1..2] == ['Two', 'Three']

// gets another range
assert list[-1..-2] == ['Three', 'Two']

// iterates the list
def emptyList = []
list.each {emptyList << "$it!"}
assert emptyList == ['One!', 'Two!', 'Three!']

list = [1, 2, 3]
// iterates the list and transforms each entry into a new value
// using the closure
assert list.collect {it * 2} == [2, 4, 6]

// sorts using the closure as a comparator
assert list.sort {it1, it2 -> it1 <=> it2} == [1, 2, 3]

// gets min or max using closure as comparator
assert list.min {it1, it2 -> it1 <=> it2} == 1

def map = [John: 10, Mark: 20, Peter: 'Not defined']

// the array style
assert map['Peter'] == 'Not defined'

// the bean style
assert map.Mark == 20

// also you can preset default value that will be returned by
// the get method if key does not exist
assert map.get('Michael', 100) == 100

