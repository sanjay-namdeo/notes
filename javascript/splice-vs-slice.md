## Splice vs Slice

|Splice|Slice|
|---|---|
|The splice() method returns the removed item(s) in an array|The slice() method returns the selected element(s) in an array, as a new array object|
|The splice() method changes the original array|The slice() method doesn’t change the original array|
|The splice() method can take n number of arguments|The slice() method takes 2 arguments|

> Note: Splice and Slice both are Javascript Array functions.

### Splice with Example

Argument 1: Index, Required. An integer that specifies at what position to add /remove items, Use negative values to specify the position from the end of the array.

Argument 2: Optional. The number of items to be removed. If set to 0(zero), no items will be removed. And if not passed, all item(s) from provided index will be removed.

Argument 3…n: Optional. The new item(s) to be added to the array.

```javascript
var array=[1,2,3,4,5];
console.log(array.splice(2));
// shows [3, 4, 5], returned removed item(s) as a new array object.
 
console.log(array);
// shows [1, 2], original array altered.
 
var array2=[6,7,8,9,0];
console.log(array2.splice(2,1));
// shows [8]
 
console.log(array2.splice(2,0));
//shows [] , as no item(s) removed.
 
console.log(array2);
// shows [6,7,9,0]
```

### Slice with Example

Argument 1: Required. An integer that specifies where to start the selection (The first element has an index of 0). Use negative numbers to select from the end of an array.

Argument 2: Optional. An integer that specifies where to end the selection but does not include. If omitted, all elements from the start position and to the end of the array will be selected. Use negative numbers to select from the end of an array.

```javascript
var array=[1,2,3,4,5]
console.log(array.slice(2));
// shows [3, 4, 5], returned selected element(s).
 
console.log(array.slice(-2));
// shows [4, 5], returned selected element(s).
console.log(array);
// shows [1, 2, 3, 4, 5], original array remains intact.
 
var array2=[6,7,8,9,0];
console.log(array2.slice(2,4));
// shows [8, 9]
 
console.log(array2.slice(-2,4));
// shows [9]
 
console.log(array2.slice(-3,-1));
// shows [8, 9]
 
console.log(array2);
// shows [6, 7, 8, 9, 0]
```

#### Reference
[Stackoverflow](https://stackoverflow.com/questions/37601282/javascript-array-splice-vs-slice)
