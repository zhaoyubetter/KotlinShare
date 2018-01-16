//数组解构
var array = [1,2,3]
var [first,second,third] = array
console.log(first,second,third)
//对象解构
var {foo,bar} = {foo: "hello", bar: "world"}
console.log(foo,bar)
//嵌套解构
var [first,[[second],third] = [1,[[2],3]]]
console.log(first,second,third)

var obj = {
    arrayProp: [
        "Zapp",
        { second: "Brannigan" }
    ]
}
var { arrayProp: [first, { second }] } = obj