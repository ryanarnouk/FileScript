# FileScript

## Overview

FileScript is a domain specific language (DSL) designed for flexible file searches based on metadata and other file properties.

It draws inspiration from Lua and Bash, incorporating features commonly found in general-purpose programming languages. With a Lua-like syntax and scripting style, FileScript supports dynamic type checking, mutable variables, loops, conditionals, and stack data structures. This enables expressive stack-based traversal and depth-first search workflows.  

## Contributors

This project was developed by Ryan Arnouk, Yingkai Zhao, Sunny Nie, Mike Wang, and Alan Zhang.

> Note: Git history was removed before publishing this repository, as the original development took place on a private enterprise server.  

## Documentation
#### Stack
```
stack = {}
```
- A stack is initialized with `{}`. In FileScript, a stack is treated as an iterable, allowing loops to iterate over each file in the stack. A stack can hold files as well as other types.
```
push(stack, file)
file = pop(stack)
```
- Push a file onto the (end) of the stack.
- Pop a file (from the end) of the stack.
```
push(stack, open("/file/path/"))
```
- Can push file to end of another stack

#### `open` Method
```
open("/foo/main.py")    // returns the file at /foo/main.py
open("/foo/bar")        // returns the file /foo/bar
open("/foo/bar/")       // returns the file /foo/bar
```

#### Stack Operations
```
length = len(stack)
```
- Returns the length of the stack as an integer.
```
file = stack[3]
```
- A stack can also be used as a list/array. This returns the file at index 3 of the stack. Indexing starts from 0.
- Stacks do not support negative indexes.

#### Other Data Types
```
an_integer = 1
a_string = "asdf"
boolean = true
```
- The following are **not** supported: floats/doubles (e.g., `1.2`).

#### Conditionals
```
while <condition> do
   <code>
end
```
- A while loop executes `<code>` as long as `<condition>` is true.
```
if <condition> then
  <code>
else
  <code>
end
```
- If `<condition>` is true, it executes the first block. Otherwise, it executes the `else` block.

#### Comments
```
// for in-line comments
```
- There are no block comments.

#### Mutable Variables
- All variables are mutable and have infinite scope.
```
if true then
  x = open("/home/")    // x is initialized as a stack of files
  x = false             // x is a boolean (false)
  x = x == 0            // false, false != 0
  x = 0                 // x is 0
end
x = 1                   // x is 1
```

#### Files
```
name_of_file = file['name']             // "src/hello.py"
int_size = file['size']                 // in bytes
is_dir = file['is_dir']                 // boolean if it is directory
sub_files = file['subs']                 // See notes below
```
- A file can be either a file or a directory.
- The `subs` attribute gets the subfiles (and subdirectories) as a `stack`. If used on a file (not a directory), it returns `{}` (an empty stack).
- `subs` is **not** recursive; it only retrieves the immediate children.

#### Math Operations
```
1 < 2  // true
1 > 2  // false
1 == 2 // false
1 != 2 // true
1 + 2  // 3
1 - 2  // -1
1 >= 2 // false
1 <= 2 // true
```
- Supported operators: `+`, `-`, `<`, `>`, `==`, `!=`, `<=`, `>=`, `*`, `/`.
- Not supported: `%`
- No assignment operators (`+=`, `-=`)

#### Printing
```
print("Hello world!")     // Hello world!
print("1 + 2 = ", 1 + 2)   // 1 + 2 = 3
print("found file: ", file['name'], " with size: ", file['size'], " bytes")
// found file: 1.txt with size: 3 bytes
```
- `print` can display any supported data type.

#### Wildcard Matching
```
"foo.txt" == "*.txt"   // true
"foo.txt" == "foo.*"   // true
"foo.txt" == "*oo.t*"  // true
```
- The `*` wildcard can only be used at the beginning, end, or both ends of a string.
- `*.txt` matches any string ending in `.txt`.
- `foo.*` matches any string starting with `foo.`.
- `*oo.t*` acts like a "contains" operation.

### Sample
Task: count the number of txt files in a folder
```
root = open('examples/sample_dir')

txt_count = 0

dirs = {}
push(dirs, root)

while len(dirs) > 0 do
    dir = pop(dirs)
    sub_files = dir['subs']
    while len(sub_files) > 0 do
        sub = open(pop(sub_files))
        if sub['is_dir'] then
            push(dirs, sub)
        else
            if sub['name'] == '*.txt' then
                print('found txt file: ', sub['name'])
                txt_count = txt_count + 1
            end
        end
    end
end
print('total txt', txt_count)

```