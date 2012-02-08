{exec} = require 'child_process'
fs = require 'fs'

defaultSize = 1000000

runSync = (cmd, next) -> 
  exec cmd, (err, stdout, stderr) ->
    throw err if err
    console.log stdout + stderr
    next() if typeof next is 'function'

option '-s', '--sizeofarray [ARRAY_LENGTH]', 'size of array to sort, default 1,000,000'

task 'run:java', 'run java quicksort', (options) ->
  options.sizeofarray or= defaultSize

  runSync "javac Quicksort.java", ->
    runSync "java Quicksort " + options.sizeofarray,  ->
      fs.unlinkSync process.cwd() + "\\Quicksort.class"

task 'run:javaapi', 'run java Arrays.sort()', (options) ->
  options.sizeofarray or= defaultSize

  runSync "javac ArrayApi.java", ->
    runSync "java ArrayApi " + options.sizeofarray,  ->
      fs.unlinkSync process.cwd() + "\\ArrayApi.class"

task 'run:scala', 'run scala quicksort', (options) ->
  options.sizeofarray or= defaultSize

  runSync "scala Quicksort.scala " + options.sizeofarray

task 'run:coffee', 'run coffeescript (node.js/v8) quicksort', (options) ->
  options.sizeofarray or= defaultSize

  runSync "coffee quicksort.coffee " + options.sizeofarray

task 'run:coffeeapi', 'run javascript v8 Array.sort (node.js/v8)', (options) ->
  options.sizeofarray or= defaultSize

  runSync "coffee sortapi.coffee " + options.sizeofarray

task 'run:php', 'run php quicksort', (options) ->
  options.sizeofarray or= defaultSize

  runSync "php -q quicksort.php " + options.sizeofarray

task 'run:phpapi', 'run php sort()', (options) ->
  options.sizeofarray or= defaultSize

  runSync "php -q phpsort.php " + options.sizeofarray

task 'run:groovy', 'run groovy quicksort', (options) ->
  options.sizeofarray or= defaultSize

  runSync "groovy Quicksort.groovy " + options.sizeofarray

task 'run:groovyapi', 'run groovy Arrays.sort() (same as java??)', (options) ->
  options.sizeofarray or= defaultSize

  runSync "groovy SortApi.groovy " + options.sizeofarray

task 'run:ruby', 'run ruby quicksort', (options) ->
  options.sizeofarray or= defaultSize

  runSync "ruby quicksort.rb " + options.sizeofarray

task 'run:rubyapi', 'run ruby api sort!', (options) ->
  options.sizeofarray or= defaultSize

  runSync "ruby sortapi.rb " + options.sizeofarray

task 'run:python', 'run python quicksort', (options) ->
  options.sizeofarray or= defaultSize

  runSync "python quicksort.py " + options.sizeofarray

task 'run:pythonapi', 'run python api sort()', (options) ->
  options.sizeofarray or= defaultSize

  runSync "python sortapi.py " + options.sizeofarray


task 'run:csharp', 'run c# quicksort', (options) ->
  options.sizeofarray or= defaultSize

  runSync "C:\\Windows\\Microsoft.NET\\Framework64\\v3.5\\csc.exe Quicksort.cs", ->
    runSync "Quicksort.exe " + options.sizeofarray, ->
      fs.unlinkSync process.cwd() + "\\Quicksort.exe"

task 'run:csharpapi', 'run java Arrays.sort()', (options) ->
  options.sizeofarray or= defaultSize

  runSync "C:\\Windows\\Microsoft.NET\\Framework64\\v3.5\\csc.exe ArrayApi.cs", ->
    runSync "ArrayApi.exe " + options.sizeofarray, ->
      fs.unlinkSync process.cwd() + "\\ArrayApi.exe"

task 'run:cpp', 'run cpp quicksort', (options) ->
  options.sizeofarray or= defaultSize

  console.log "\n******\n* You need to run \"C:\\Program Files (x86)\\Microsoft Visual Studio 10.0\\VC\\bin\\vcvars32.bat\" first to setup the necessary environment\n******"
  runSync "\"C:\\Program Files (x86)\\Microsoft Visual Studio 10.0\\VC\\bin\\cl.exe\" /W3 /WX- /O2 /Oi /Oy- /GL /D \"WIN32\" /D \"NDEBUG\" /EHsc /GS /Gy /fp:precise /Gd /oquicksort.exe /INCREMENTAL:NO /OPT:REF /OPT:ICF /DYNAMICBASE /ERRORREPORT:QUEUE Winmm.lib quicksort.cpp", ->
    runSync "quicksort.exe " + options.sizeofarray, ->
      fs.unlinkSync process.cwd() + "\\quicksort.exe"
      fs.unlinkSync process.cwd() + "\\quicksort.obj"