## org.tinyj.lava

### Rex
_[(src)](src/main/java/org/tinyj/lava/Rex.java)_

Utility class

**`runnable(RexRunnable runnable)`**  
⇒ *`Runnable`* _(`runnable`)_  
This method simplifies the creation of [`RexRunnable`](#rexrunnablee) lambdas in places where a
 [Runnable](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html) is
 is expected. E.g. `new Thread(Rex.runnable(() -> {...code throwing checked exception...}))`

**`supplier(RexSupplier<R, ?> supplier)`**  
⇒ *`Supplier<R>`* _(`supplier`)_  
This method simplifies the creation of [`RexSupplier`](#rexsupplierr-e) lambdas in places where a
 [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)
 is expected. E.g. `Stream.generate(Rex.supplier(() -> {...code throwing checked exception...}))`

**`function(RexFunction<X, R, ?> function)`**  
⇒ *`Function<X, R>`* _(`function`)_  
This method simplifies the creation of [`RexFunction`](#rexfunctionx-r-e) lambdas in places where a
 [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)
 is expected. E.g. `Stream.map(Rex.function(element -> {...code throwing checked exception...}))`

**`biFunction(RexBiFunction<X, Y, R, ?> biFunction)`**  
⇒ *`BiFunction<X, Y, R>`* _(`biFunction`)_  
This method simplifies the creation of [`RexBiFunction`](#rexbifunctionx-y-r-e) lambdas in places where a
 [BiFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)
 is expected. E.g. `map.replaceAll(Rex.biFunction((key, value) -> {...code throwing checked exception...}))`

**`consumer(RexConsumer<X, ?> consumer)`**  
⇒ *`Consumer<X>`* _(`consumer`)_  
This method simplifies the creation of [`RexConsumer`](#rexconsumerx-e) lambdas in places where a
 [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)
 is expected. E.g. `stream.forEach(Rex.consumer(element -> {...code throwing checked exception...}))`

**`biConsumer(RexBiConsumer<X, Y, ?> biConsumer)`**  
⇒ *`BiConsumer<X, Y>`* _(`biConsumer`)_  
This method simplifies the creation of [`RexBiConsumer`](#rexbiconsumerx-y-e) lambdas in places where a
 [BiConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)
 is expected. E.g. `map.forEach(Rex.biConsumer((key, value) -> {...code throwing checked exception...}))`

**`predicate(RexPredicate<X, ?> predicate)`**  
⇒ *`Predicate<X>`* _(`predicate`)_  
This method simplifies the creation of [`RexPredicate`](#rexpredicatex-e) lambdas in places where a
 [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
 is expected. E.g. `stream.filter(Rex.predicate(element -> {...code throwing checked exception...}))`

**`biPredicate(RexBiPredicate<X, Y, ?> biPredicate)`**  
⇒ *`BiPredicate<X, Y>`* _(`biPredicate`)_  
This method simplifies the creation of [`RexBiPredicate`](#rexbipredicatex-y-e) lambdas in places where a
 [BiPredicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html)
 is expected. E.g. `Files.find(start, depth, Rex.biPredicate((path, attributes) -> {...code throwing checked exception...}))`

**`unaryOp(RexFunction<X, X, ?> operator)`**  
⇒ *`Function<X, X>`*  
This method is equivalent to `Rex.function(operator)`.

**`binaryOp(RexBiFunction<X, X, X, ?> operator)`**  
⇒ *`BiFunction<X, X, X>`*  
This method is equivalent to `Rex.biFunction(operator)`.

**`relation(RexBiPredicate<X, X, ?> relation)`**  
⇒ *`BiPredicate<X, X>`*  
This method is equivalent to `Rex.biPredicate(relation)`.

**`rex(<any> checked)`**  
⇒ *`Runnable`*  
Bridge [LavaRunnable](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavarunnablee)
 to [Runnable](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)
 by wrapping checked exceptions raised.

**`rex(<any> checked)`**  
⇒ *`Consumer<X>`*  
Bridge [LavaConsumer](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavaconsumerx-e)
 to [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)
 by wrapping checked exceptions raised.

**`rex(<any> checked)`**  
⇒ *`BiConsumer<X, Y>`*  
Bridge [LavaBiConsumer](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabiconsumerx-y-e)
 to [BiConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)
 by wrapping checked exceptions raised.

**`rex(<any> checked)`**  
⇒ *`Supplier<R>`*  
Bridge [LavaSupplier](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavasupplierr-e)
 to [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)
 by wrapping checked exceptions raised.

**`rex(<any> checked)`**  
⇒ *`Function<X, R>`*  
Bridge [LavaFunction](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavafunctionx-r-e)
 to [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)
 by wrapping checked exceptions raised.

**`rex(<any> checked)`**  
⇒ *`BiFunction<X, Y, R>`*  
Bridge [LavaBiFunction](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabifunctionx-y-r-e)
 to [BiFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)
 by wrapping checked exceptions raised.

**`rex(<any> checked)`**  
⇒ *`Predicate<X>`*  
Bridge [LavaPredicate](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavapredicatex-e)
 to [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
 by wrapping checked exceptions raised.

**`rex(<any> checked)`**  
⇒ *`BiPredicate<X, Y>`*  
Bridge [LavaBiPredicate](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabipredicatex-y-e)
 to [BiPredicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html)
 by wrapping checked exceptions raised.

## org.tinyj.lava.rex

### RexBiConsumer\<X, Y, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexBiConsumer.java)_ |
_(interface)_ |
X: first consumed value type — Y: second consumed value type — E: upper limit of thrown exception types  
_implements_ (#BiConsumer)

An operation on two input values. This interface bridges
 [LavaBiConsumer](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabiconsumerx-y-e)
 and
 [BiConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)
 by wrapping checked exceptions raised during invocation of `accept(...)` into a
 [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).

 Usually invoking a bi-consumer results in side effects. Subsequent
 invocations may or may not result in further side effects.

 This is a functional interface whose functional method is `checkedAccept(X, Y)`.

**`accept(X x, Y y)`**  
Perform operation on inputs, wrap checked exceptions.

**`castDown(RexBiConsumer<? super X, ? super Y, ? extends E> biConsumer)`**  
⇒ *`RexBiConsumer<X, Y, E>`* _(`biConsumer` casted to the compatible parametrization [`RexBiConsumer`](#rexbiconsumerx-y-e)`<X, Y, E>`)_  
Safely casts between different [`RexBiConsumer`](#rexbiconsumerx-y-e) parametrization

### RexBiFunction\<X, Y, R, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexBiFunction.java)_ |
_(interface)_ |
X: the bi-function's first argument type — Y: the bi-function's second argument type — R: the bi-function's result type — E: upper limit of thrown exception types  
_implements_ (#BiFunction)

A bi-function maps its two argument to a result. This interface bridges
 [LavaBiFunction](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabifunctionx-y-r-e)
 and
 [BiFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)
 by wrapping checked exceptions raised during invocation of `apply(...)` into a
 [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).

 While not strictly required it usually is expected that subsequent
 invocations with the same arguments yield equal results.

 This is a functional interface whose functional method is `checkedApply(X, Y)`.

**`apply(X x, Y y)`**  
⇒ *`R`* _(the function's result)_  
Apply the function to arguments, wrap checked exceptions.

**`castDown(RexBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction)`**  
⇒ *`RexBiFunction<X, Y, R, E>`* _(`biFunction` casted to the compatible parametrization [`RexBiFunction`](#rexbifunctionx-y-r-e)`<X, Y, R, E>`)_  
Safely casts between different [`RexBiFunction`](#rexbifunctionx-y-r-e) parametrization

### RexBiPredicate\<X, Y, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexBiPredicate.java)_ |
_(interface)_ |
X: the function's argument type — E: upper limit of thrown exception types  
_implements_ (#BiPredicate)

A special kind of bi-function mapping its arguments to a `boolean` result.
 This interface bridges
 [LavaBiPredicate](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabipredicatex-y-e)
 and
 [BiPredicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html)
 by wrapping checked exceptions raised during invocation of `test(...)` into a
 [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).


 While not strictly required it usually is expected that subsequent
 invocations with the same argument yield equal results.

 This is a functional interface whose functional method is `checkedTest(X, Y)`.

**`test(X x, Y y)`**  
⇒ *`boolean`* _(`true` if `x` matches, `false` otherwise)_  
Test if the arguments matches the predicate, wrap checked exceptions.

**`castDown(RexBiPredicate<? super X, ? super Y, ? extends E> biPredicate)`**  
⇒ *`RexBiPredicate<X, Y, E>`* _(`biPredicate` casted to the compatible parametrization [`RexBiPredicate`](#rexbipredicatex-y-e)`<X, E>`)_  
Safely casts between different [`RexBiPredicate`](#rexbipredicatex-y-e)parametrization

### RexConsumer\<X, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexConsumer.java)_ |
_(interface)_ |
X: consumed value type — E: upper limit of thrown exception types  
_implements_ (#Consumer)

An operation on an input value. This interface bridges
 [LavaConsumer](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavaconsumerx-e)
 and
 [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)
 by wrapping checked exceptions raised during invocation of `accept(...)` into a
 [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).

 Usually invoking a consumer results in side effects. Subsequent
 invocations may or may not result in further side effects.

 This is a functional interface whose functional method is `checkedAccept(X)`.

**`accept(X x)`**  
Perform operation on input, wrap checked exceptions.

**`castDown(RexConsumer<? super X, ? extends E> consumer)`**  
⇒ *`RexConsumer<X, E>`* _(`consumer` casted to the compatible parametrization [`RexConsumer`](#rexconsumerx-e)`<X, E>`)_  
Safely casts between different [`RexConsumer`](#rexconsumerx-e) parametrization

### RexFunction\<X, R, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexFunction.java)_ |
_(interface)_ |
X: the function's argument type — R: the function's result type — E: upper limit of thrown exception types  
_implements_ (#Function)

A function maps its argument to a result. This interface bridges
 [LavaFunction](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavafunctionx-r-e)
 and
 [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)
 by wrapping checked exceptions raised during invocation of `apply(...)` into a
 [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).

 While not strictly required it usually is expected that subsequent
 invocations with the same argument yield equal results.

 This is a functional interface whose functional method is `checkedApply(X)`.

**`apply(X x)`**  
⇒ *`R`* _(the function's result)_  
Apply the function to an argument, wrap checked exceptions.

**`castDown(RexFunction<? super X, ? extends R, ? extends E> function)`**  
⇒ *`RexFunction<X, R, E>`* _(`function` casted to the compatible parametrization [`RexFunction`](#rexfunctionx-r-e)`<X, R, E>`)_  
Safely casts between different [`RexFunction`](#rexfunctionx-r-e) parametrization

### RexPredicate\<X, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexPredicate.java)_ |
_(interface)_ |
X: the function's argument type — E: upper limit of thrown exception types  
_implements_ (#Predicate)

A special kind of function mapping its argument to
 a {@code boolean} result.
 This interface bridges
 [LavaPredicate](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavapredicatex-e)
 and
 [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
 by wrapping checked exceptions raised during invocation of `test(...)` into a
 [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).

 While not strictly required it usually is expected that subsequent
 invocations with the same argument yield equal results.

 This is a functional interface whose functional method is {@link #checkedTest(X)}.

**`test(X x)`**  
⇒ *`boolean`* _(`true` if `x` matches, `false` otherwise)_  
Test if the argument matches the predicate, wrap checked Exceptions.

**`castDown(RexPredicate<? super X, ? extends E> predicate)`**  
⇒ *`RexPredicate<X, E>`* _(`predicate` casted to the compatible parametrization [`RexPredicate`](#rexpredicatex-e)`<X, E>`)_  
Safely casts between different [`RexPredicate`](#rexpredicatex-e) parametrization

### RexRunnable\<E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexRunnable.java)_ |
_(interface)_ |
E: upper limit of thrown exception types  
_implements_ (#Runnable)

A runnable task. This interface bridges
 [LavaRunnable](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavarunnablee)
 and
 [Runnable](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)
 by wrapping checked exceptions raised during invocation of `run(...)` into a
 [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).

 Usually invoking a runnable results in side effects. Subsequent
 invocations may or may not result in further side effects.

 This is a functional interface whose functional method is `checkedRun()`.

**`run()`**  
Execute the task, wrap checked Exceptions.

**`castDown(RexRunnable<? extends E> runnable)`**  
⇒ *`RexRunnable<E>`* _(`runnable` casted to the compatible parametrization [`RexRunnable`](#rexrunnablee)`<E>`)_  
Safely casts between different [`RexRunnable`](#rexrunnablee) parametrization

### RexSupplier\<R, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexSupplier.java)_ |
_(interface)_ |
R: type of supplied values — E: upper limit of thrown exception types  
_implements_ (#Supplier)

A supplier of values. This interface bridges
 [LavaSupplier](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavasupplierr-e)
 and
 [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)
 by wrapping checked exceptions raised during invocation of `get(...)` into a
 [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).

 There is no requirement that a new or distinct result be returned each
 time the supplier is invoked.

 This is a functional interface whose functional method is `checkedGet()`.

**`get()`**  
⇒ *`R`* _(a value)_  
Produce a value, wrap checked Exceptions.

**`castDown(RexSupplier<? extends R, ? extends E> supplier)`**  
⇒ *`RexSupplier<R, E>`* _(`supplier` casted to the compatible parametrization [`RexSupplier`](#rexsupplierr-e)`<R, E>`)_  
Safely casts between different [`RexSupplier`](#rexsupplierr-e) parametrization

