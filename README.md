
# TinyJ Lava-Rex
[![build status](https://travis-ci.org/tinyj/tinyj-lava-rex.svg?branch=master)](https://travis-ci.org/tinyj/tinyj-lava-rex)

Bridge lava-api's functional interfaces to Java's functional interfaces by
wrapping checked exceptions.

Java's default functional interfaces (i.e. `java.util.function.Function` and
friends) allow not for raising checked exception, which practically denies us
from using these neat lambda shorthands for anything that may throw checked
exceptions. While the interfaces defined in tinyj-lava-api allow us to create
lambdas throwing checked exceptions, tinyj-lava-rex provides the glue to allow
us to use these lambdas in places where only Java's default interfaces are
accepted.


## API documentation

You can find the API documentation [here](APIdoc.md).


## License

Copyright 2016 Eric Karge <e.karge@struction.de>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
