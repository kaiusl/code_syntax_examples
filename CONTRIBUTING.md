# Contributing

Every contribution is very much welcome. You can file an issue, or even better a PR with the addition, for a mistake, suggestion or missing elements in existing examples or for a completely new examples.

## Issues

Before filing a new issue please search for similar existing issues. 

## PRs

There are few guidelines that probably should be followed. I say probably because any sample is better than no sample and thus we shouldn't be very picky about example style or content. There are already some quick examples in this repo that do not conform to the guidelines below, but these can be gradually improved.

### Example style guide

* The example is valid project, it will compile and run without errors.

  That is it should contain any files needed to compile and run the project. For example Rust example includes the Cargo.toml file. This is so that any semantic highlighting or other special features will work as they would on a real project. 
* If a build system is needed it should be the most common and simplest one. 
  * A README.md file with instruction for how to build and run is welcome addition.
* Checking the syntax theme is as simple as opening the folder of specific language in an editor that's configured to use that language.
* Ideally works on multiple platforms with different editors. If that's not possible add a note to the README.md for that language.
* Uses as few external libraries as possible. If the project needs some external libaries add a README.md that lists them and how to install them.
* The sample only contains syntactically valid code.

  In some cases a syntax error can mess up whole highlighting.
* Items are named in a way that reflects what they are.

   For example struct should be named `SomeStruct` or `FooStruct` or something similar. Thus it's easy for someone who is not that familiar with the specific language to still understand what each component represent (or easily find out).
* Is relatively compact and combine different elements where possible.

   For example, there is no need to provide a struct without generic, one with generic, one with attributes but without generics and so on. It's sufficient to have one that has all of these elements, unless the code becomes unreadable or there is some special need why these different kinds of same thing should be treated differently.
* Related items are be grouped together.
* In general avoid unused code, unreachable statements or other things that the editor can add overlays. An specific example of unused code (or other overlay candidates) can be added as an extra.

That's it. 

Thank you contributing to this project. 