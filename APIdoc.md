## org.tinyj.lava.rex

### Rex
_[(src)](src/main/java/org/tinyj/lava/rex/Rex.java)_

Utility class

**`Rex()`** _(contructor)_  
Do not instantiate

_**`runnable(RexRunnable<? extends E> runnable)`**_
⇒ *`RexRunnable<E>`* *(`runnable`)*  
`E`: upper exception limit  
`runnable`: lambda  
This method simplifies the creation of [`RexRunnable`] lambdas in
places where a [`Runnable`] is expected or disambiguation between
[`RexSupplier`] and [`RexRunnable`] is required.

E.g. `new Thread(Rex.runnable(() -> {...code throwing checked exception...}))`

_**`supplier(RexSupplier<? extends R, ? extends E> supplier)`**_
⇒ *`RexSupplier<R, E>`* *(`supplier`)*  
`R`: return type  
`E`: upper exception limit  
`supplier`: lambda  
This method simplifies the creation of [`RexSupplier`] lambdas in
places where a [`Supplier`] is expected or disambiguation between
[`RexSupplier`] and [`RexRunnable`] is required.

E.g. `Stream.generate(Rex.supplier(() -> {...code throwing checked exception...}))`

_**`function(RexFunction<? super X, ? extends R, ? extends E> function)`**_
⇒ *`RexFunction<X, R, E>`* *(`function`)*  
`X`: parameter type  
`R`: return type  
`E`: upper exception limit  
`function`: lambda  
This method simplifies the creation of [`RexFunction`] lambdas in
places where a [`Function`] is expected or a disambiguation between
[`RexFunction`] and [`RexConsumer`] is required.

E.g. `Stream.map(Rex.function(element -> {...code throwing checked exception...}))`

_**`biFunction(RexBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction)`**_
⇒ *`RexBiFunction<X, Y, R, E>`* *(`biFunction`)*  
`X`: first parameter type  
`Y`: second parameter type  
`R`: return type  
`E`: upper exception limit  
`biFunction`: lambda  
This method simplifies the creation of [`RexBiFunction`] lambdas in
places where a [`BiFunction`] is expected or a disambiguation between
[`RexBiFunction`] and [`RexBiConsumer`] is required.

E.g. `map.replaceAll(Rex.biFunction((key, value) -> {...code throwing checked exception...}))`

_**`consumer(RexConsumer<? super X, ? extends E> consumer)`**_
⇒ *`RexConsumer<X, E>`* *(`consumer`)*  
`X`: parameter type  
`E`: upper exception limit  
`consumer`: lambda  
This method simplifies the creation of [`RexConsumer`] lambdas in
places where a [`Consumer`] is expected or a disambiguation between
[`RexFunction`] and [`RexConsumer`] is required.

E.g. `stream.forEach(Rex.consumer(element -> {...code throwing checked exception...}))`

_**`biConsumer(RexBiConsumer<? super X, ? super Y, ? extends E> biConsumer)`**_
⇒ *`RexBiConsumer<X, Y, E>`* *(`biConsumer`)*  
`X`: first parameter type  
`Y`: second parameter type  
`E`: upper exception limit  
`biConsumer`: lambda  
This method simplifies the creation of [`RexBiConsumer`] lambdas in
places where a [`BiConsumer`] is expected or a disambiguation between
[`RexBiFunction`] and [`RexBiConsumer`] is required.

E.g. `map.forEach(Rex.biConsumer((key, value) -> {...code throwing checked exception...}))`

_**`predicate(RexPredicate<? super X, ? extends E> predicate)`**_
⇒ *`RexPredicate<X, E>`* *(`predicate`)*  
`X`: parameter type  
`E`: upper exception limit  
`predicate`: lambda  
This method simplifies the creation of [`RexPredicate`] lambdas in
places where a [`Predicate`] is expected or a disambiguation between
[`RexFunction`] and [`RexPredicate`] is required.

E.g. `stream.filter(Rex.predicate(element -> {...code throwing checked exception...}))`

_**`biPredicate(RexBiPredicate<? super X, ? super Y, ? extends E> biPredicate)`**_
⇒ *`RexBiPredicate<X, Y, E>`* *(`biPredicate`)*  
`X`: first parameter type  
`Y`: second parameter type  
`E`: upper exception limit  
`biPredicate`: lambda  
This method simplifies the creation of [`RexBiPredicate`] lambdas in
places where a [`BiPredicate`] is expected or a disambiguation between
[`RexFunction`] and [`RexBiPredicate`] is required.

E.g. `Files.find(start, depth, Rex.biPredicate((path, attributes) -> {...code throwing checked exception...}))`

_**`unaryOp(RexFunction<? super X, ? extends X, ? extends E> operator)`**_
⇒ *`RexFunction<X, X, E>`* *(`operator`)*  
`X`: parameter type  
`E`: upper exception limit  
`operator`: lambda  
This method is equivalent to `function(operator)`.

_**`binaryOp(RexBiFunction<? super X, ? super X, ? extends X, ? extends E> operator)`**_
⇒ *`RexBiFunction<X, X, X, E>`* *(`operator`)*  
`X`: parameter type  
`E`: upper exception limit  
`operator`: lambda  
This method is equivalent to `biFunction(operator)`.

_**`relation(RexBiPredicate<? super X, ? super X, ? extends E> relation)`**_
⇒ *`RexBiPredicate<X, X, E>`* *(`operator`)*  
`X`: parameter type  
`E`: upper exception limit  
`relation`: lambda  
This method is equivalent to `biPredicate(relation)`.

_**`rex(LavaRunnable<? extends E> checked)`**_
⇒ *`RexRunnable<E>`* *([`RexRunnable`] wrapping `checked`)*  
`E`: upper exception limit  
`checked`: [`LavaRunnable`] to wrap  
Bridge [`LavaRunnable`] to [`Runnable`] by wrapping checked
exceptions raised.

_**`rex(LavaConsumer<? super X, ? extends E> checked)`**_
⇒ *`RexConsumer<X, E>`* *([`RexConsumer`] wrapping `checked`)*  
`X`: parameter type  
`E`: upper exception limit  
`checked`: [`LavaConsumer`] to wrap  
Bridge [`LavaConsumer`] to [`Consumer`] by wrapping checked
exceptions raised.

_**`rex(LavaBiConsumer<? super X, ? super Y, ? extends E> checked)`**_
⇒ *`RexBiConsumer<X, Y, E>`* *([`RexBiConsumer`] wrapping `checked`)*  
`X`: first parameter type  
`Y`: second parameter type  
`E`: upper exception limit  
`checked`: [`LavaBiConsumer`] to wrap  
Bridge [`LavaBiConsumer`] to [`BiConsumer`] by wrapping checked
exceptions raised.

_**`rex(LavaSupplier<? extends R, ? extends E> checked)`**_
⇒ *`RexSupplier<R, E>`* *([`RexSupplier`] wrapping `checked`)*  
`R`: return type  
`E`: upper exception limit  
`checked`: [`LavaSupplier`] to wrap  
Bridge [`LavaSupplier`] to [`Supplier`] by wrapping checked
exceptions raised.

_**`rex(LavaFunction<? super X, ? extends R, ? extends E> checked)`**_
⇒ *`RexFunction<X, R, E>`* *([`RexFunction`] wrapping `checked`)*  
`X`: parameter type  
`R`: return type  
`E`: upper exception limit  
`checked`: [`LavaFunction`] to wrap  
Bridge [`LavaFunction`] to [`Function`] by wrapping checked
exceptions raised.

_**`rex(LavaBiFunction<? super X, ? super Y, ? extends R, ? extends E> checked)`**_
⇒ *`RexBiFunction<X, Y, R, E>`* *([`RexBiFunction`] wrapping `checked`)*  
`X`: first parameter type  
`Y`: second parameter type  
`R`: return type  
`E`: upper exception limit  
`checked`: [`LavaBiFunction`] to wrap  
Bridge [`LavaBiFunction`] to [`BiFunction`] by wrapping checked
exceptions raised.

_**`rex(LavaBooleanSupplier<? extends E> checked)`**_
⇒ *`RexBooleanSupplier<E>`* *([`RexBooleanSupplier`] wrapping `checked`)*  
`E`: upper exception limit  
`checked`: [`LavaBooleanSupplier`] to wrap  
Bridge [`LavaBooleanSupplier`] to [`BooleanSupplier`] by wrapping checked
exceptions raised.

_**`rex(LavaPredicate<? super X, ? extends E> checked)`**_
⇒ *`RexPredicate<X, E>`* *([`RexPredicate`] wrapping `checked`)*  
`X`: parameter type  
`E`: upper exception limit  
`checked`: [`LavaPredicate`] to wrap  
Bridge [`LavaPredicate`] to [`Predicate`] by wrapping checked
exceptions raised.

_**`rex(LavaBiPredicate<? super X, ? super Y, ? extends E> checked)`**_
⇒ *`RexBiPredicate<X, Y, E>`* *([`RexConsumer`] wrapping `checked`)*  
`X`: first parameter type  
`Y`: second parameter type  
`E`: upper exception limit  
`checked`: [`LavaConsumer`] to wrap  
Bridge [`LavaBiPredicate`] to [`BiPredicate`] by wrapping checked
exceptions raised.

_**`invoke(LavaRunnable<?> checked)`**_  
`checked`: [`LavaRunnable`] to invoke  
Convenience method invoking [`LavaRunnable`] wrapping checked
exceptions raised.

Equivalent to `rex(checked).run()`

_**`invoke(LavaConsumer<X, ?> checked, X x)`**_  
`X`: parameter type  
`checked`: [`LavaConsumer`] to invoke  
`x`: parameter to `checked`  
Convenience method invoking [`LavaConsumer`] wrapping checked
exceptions raised.

Equivalent to `rex(checked).accept(x)`

_**`invoke(LavaBiConsumer<X, Y, ?> checked, X x, Y y)`**_  
`X`: first parameter type  
`Y`: second parameter type  
`checked`: [`LavaBiConsumer`] to invoke  
`x`: first parameter to `checked`  
`y`: second parameter to `checked`  
Convenience method invoking [`LavaBiConsumer`] wrapping checked
exceptions raised.

Equivalent to `rex(checked).accept(x, y)`

_**`invoke(LavaSupplier<R, ?> checked)`**_
⇒ *`R`* *(result of invoking `checked`)*  
`R`: return type  
`checked`: [`LavaSupplier`] to invoke  
Convenience method invoking [`LavaSupplier`] wrapping checked
exceptions raised.

Equivalent to `rex(checked).get()`

_**`invoke(LavaFunction<X, R, ?> checked, X x)`**_
⇒ *`R`* *(result of invoking `checked`)*  
`X`: parameter type  
`R`: return type  
`checked`: [`LavaFunction`] to invoke  
`x`: parameter to `checked`  
Convenience method invoking [`LavaFunction`] wrapping checked
exceptions raised.

Equivalent to `rex(checked).apply(x)`

_**`invoke(LavaBiFunction<X, Y, R, ?> checked, X x, Y y)`**_
⇒ *`R`* *(result of invoking `checked`)*  
`X`: first parameter type  
`Y`: second parameter type  
`R`: return type  
`checked`: [`LavaBiFunction`] to invoke  
`x`: first parameter to `checked`  
`y`: second parameter to `checked`  
Convenience method invoking [`LavaBiFunction`] wrapping checked
exceptions raised.

Equivalent to `rex(checked).apply(x, y)`

_**`invoke(LavaBooleanSupplier<?> checked)`**_
⇒ *`boolean`* *(result of invoking `checked`)*  
`X`: parameter type  
`checked`: [`LavaBooleanSupplier`] to invoke  
Convenience method invoking [`LavaBooleanSupplier`] wrapping checked
exceptions raised.

Equivalent to `rex(checked).apply(x)`

_**`invoke(LavaPredicate<X, ?> checked, X x)`**_
⇒ *`boolean`* *(result of invoking `checked`)*  
`X`: parameter type  
`checked`: [`LavaPredicate`] to invoke  
`x`: first parameter to `checked`  
Convenience method invoking [`LavaPredicate`] wrapping checked
exceptions raised.

Equivalent to `rex(checked).apply(x)`

_**`invoke(LavaBiPredicate<X, Y, ?> checked, X x, Y y)`**_
⇒ *`boolean`* *(result of invoking `checked`)*  
`X`: first parameter type  
`Y`: second parameter type  
`checked`: [`LavaBiPredicate`] to invoke  
`x`: first parameter to `checked`  
`y`: second parameter to `checked`  
Convenience method invoking [`LavaBiPredicate`] wrapping checked
exceptions raised.

Equivalent to `rex(checked).apply(x, y)`


### RexBiConsumer<X, Y, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexBiConsumer.java)_
| _(interface)_  
`X`: first consumed value type  
`Y`: second consumed value type  
`E`: upper limit of thrown exception types

An operation on two input values.

This interface bridges [`LavaBiConsumer`] and [`BiConsumer`] by
wrapping checked exceptions raised during invocation of [`accept`]
into a [`WrappedCheckedException`].

Usually invoking a bi-consumer results in side effects. Subsequent
invocations may or may not result in further side effects.

This is a functional interface whose functional method is
[`checkedAccept`].

**`accept(X x, Y y)`**  
`x`: first consumed value  
`y`: second consumed value  
Perform operation on inputs, wrap checked exceptions.

_**`castDown(RexBiConsumer<? super X, ? super Y, ? extends E> biConsumer)`**_
⇒ *`RexBiConsumer<X, Y, E>`* *(`biConsumer` casted to the compatible parametrization
[`RexBiConsumer`]`<X, Y, E>`)*  
`X`: first accepted input type  
`Y`: second accepted input type  
`E`: required exception limit  
`biConsumer`: bi-consumer to adopt  
Safely casts between different [`RexBiConsumer`] parametrization


### RexBiFunction<X, Y, R, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexBiFunction.java)_
| _(interface)_  
`X`: the bi-function's first argument type  
`Y`: the bi-function's second argument type  
`R`: the bi-function's result type  
`E`: upper limit of thrown exception types

A bi-function maps its two argument to a result.

This interface bridges [`LavaBiFunction`] and [`BiFunction`] by
wrapping checked exceptions raised during invocation of [`apply`]
into a [`WrappedCheckedException`].

While not strictly required it usually is expected that subsequent
invocations with the same arguments yield equal results.

This is a functional interface whose functional method is
[`checkedApply`].

**`apply(X x, Y y)`**
⇒ *`R`* *(the function's result)*  
`x`: first argument to map  
`y`: second argument to map  
Apply the function to arguments, wrap checked exceptions.

_**`castDown(RexBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction)`**_
⇒ *`RexBiFunction<X, Y, R, E>`* *(`biFunction` casted to the compatible parametrization
[`RexBiFunction`]`<X, Y, R, E>`)*  
`X`: first accepted argument type  
`Y`: second accepted argument type  
`R`: required result type  
`E`: required exception limit  
`biFunction`: bi-function to adopt  
Safely casts between different [`RexBiFunction`] parametrizations


### RexBiPredicate<X, Y, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexBiPredicate.java)_
| _(interface)_  
`X`: the function's argument type  
`E`: upper limit of thrown exception types

A special kind of bi-function mapping its arguments to a `boolean`.

This interface bridges [`LavaBiPredicate`] and [`BiPredicate`] by
wrapping checked exceptions raised during invocation of [`test`]
into a [`WrappedCheckedException`].

While not strictly required it usually is expected that subsequent
invocations with the same argument yield equal results.

This is a functional interface whose functional method is
[`checkedTest`].

**`test(X x, Y y)`**
⇒ *`boolean`* *(`true` if `x, y` matches, `false` otherwise)*  
`x`: first argument to the match  
`y`: second argument to the match  
Test if the arguments matches the predicate, wrap checked exceptions.

_**`castDown(RexBiPredicate<? super X, ? super Y, ? extends E> biPredicate)`**_
⇒ *`RexBiPredicate<X, Y, E>`* *(`biPredicate` casted to the compatible parametrization
[`RexBiPredicate`]`<X, E>`)*  
`X`: first accepted argument type  
`Y`: second accepted argument type  
`E`: required exception limit  
`biPredicate`: bi-predicate to adopt  
Safely casts between different [`RexBiPredicate`]parametrization


### RexBooleanSupplier\<E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexBooleanSupplier.java)_
| _(interface)_  
`E`: upper limit of thrown exception types

A supplier of values.

This interface bridges [`LavaBooleanSupplier`] and [`BooleanSupplier`] by
wrapping checked exceptions raised during invocation of [`getAsBoolean`]
into a [`WrappedCheckedException`].

There is no requirement that a new or distinct result be returned each time
the supplier is invoked.

This is a functional interface whose functional method is
[`checkedGetAsBoolean`].

**`getAsBoolean()`**
⇒ *`boolean`* *(a value)*  
Produce a value, wrap checked Exceptions.

_**`castDown(RexBooleanSupplier<? extends E> supplier)`**_
⇒ *`RexBooleanSupplier<E>`* *(`supplier` casted to the compatible parametrization [`RexBooleanSupplier`]`<R, E>`)*  
`E`: required exception limit  
`supplier`: supplier to adopt  
Safely casts between different [`RexBooleanSupplier`] parametrization


### RexConsumer<X, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexConsumer.java)_
| _(interface)_  
`X`: consumed value type  
`E`: upper limit of thrown exception types

An operation on an input value.

This interface bridges [`LavaConsumer`] and [`Consumer`] by
wrapping checked exceptions raised during invocation of [`accept`]
into a [`WrappedCheckedException`].

Usually invoking a consumer results in side effects. Subsequent
invocations may or may not result in further side effects.

This is a functional interface whose functional method is
[`checkedAccept`]

**`accept(X x)`**  
`x`: consumed value  
Perform operation on input, wrap checked exceptions.

_**`castDown(RexConsumer<? super X, ? extends E> consumer)`**_
⇒ *`RexConsumer<X, E>`* *(`consumer` casted to the compatible parametrization
[`RexConsumer`]`<X, E>`)*  
`X`: accepted input type  
`E`: required exception limit  
`consumer`: consumer to adopt  
Safely casts between different [`RexConsumer`] parametrization


### RexFunction<X, R, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexFunction.java)_
| _(interface)_  
`X`: the function's argument type  
`R`: the function's result type  
`E`: upper limit of thrown exception types

A function maps its argument to a result.

This interface bridges [`LavaFunction`] and [`Function`] by
wrapping checked exceptions raised during invocation of [`apply`]
into a [`WrappedCheckedException`].

While not strictly required it usually is expected that subsequent
invocations with the same argument yield equal results.

This is a functional interface whose functional method is
[`checkedApply`].

**`apply(X x)`**
⇒ *`R`* *(the function's result)*  
`x`: argument to map  
Apply the function to an argument, wrap checked exceptions.

_**`castDown(RexFunction<? super X, ? extends R, ? extends E> function)`**_
⇒ *`RexFunction<X, R, E>`* *(`function` casted to the compatible parametrization
[`RexFunction`]`<X, R, E>`)*  
`X`: accepted argument type  
`R`: required result type  
`E`: required exception limit  
`function`: function to adopt  
Safely casts between different [`RexFunction`] parametrization


### RexPredicate<X, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexPredicate.java)_
| _(interface)_  
`X`: the function's argument type  
`E`: upper limit of thrown exception types

A special kind of function mapping its argument to a `boolean` result.

This interface bridges [`LavaPredicate`] and [`Predicate`] by
wrapping checked exceptions raised during invocation of [`test`]
into a [`WrappedCheckedException`].

While not strictly required it usually is expected that subsequent
invocations with the same argument yield equal results.

This is a functional interface whose functional method is
[`checkedTest`].

**`test(X x)`**
⇒ *`boolean`* *(`true` if `x` matches, `false` otherwise)*  
`x`: argument to the match  
Test if the argument matches the predicate, wrap checked Exceptions.

_**`castDown(RexPredicate<? super X, ? extends E> predicate)`**_
⇒ *`RexPredicate<X, E>`* *(`predicate` casted to the compatible parametrization
[`RexPredicate`]`<X, E>`)*  
`X`: accepted argument type  
`E`: required exception limit  
`predicate`: predicate to adopt  
Safely casts between different [`RexPredicate`] parametrization


### RexRunnable\<E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexRunnable.java)_
| _(interface)_  
`E`: upper limit of thrown exception types

A runnable task.

This interface bridges [`LavaRunnable`] and [`Runnable`] by
wrapping checked exceptions raised during invocation of [`run`]
into a [`WrappedCheckedException`].

Usually invoking a runnable results in side effects. Subsequent
invocations may or may not result in further side effects.

This is a functional interface whose functional method is
[`checkedRun`].

**`run()`**  
Execute the task, wrap checked Exceptions.

_**`castDown(RexRunnable<? extends E> runnable)`**_
⇒ *`RexRunnable<E>`* *(`runnable` casted to the compatible parametrization
[`RexRunnable`]`<E>`)*  
`E`: required exception limit  
`runnable`: runnable to adopt  
Safely casts between different [`RexRunnable`] parametrization


### RexSupplier<R, E>
_[(src)](src/main/java/org/tinyj/lava/rex/RexSupplier.java)_
| _(interface)_  
`R`: type of supplied values  
`E`: upper limit of thrown exception types

A supplier of values.

This interface bridges [`LavaSupplier`] and [`Supplier`] by
wrapping checked exceptions raised during invocation of [`get`]
into a [`WrappedCheckedException`].

There is no requirement that a new or distinct result be returned each time
the supplier is invoked.

This is a functional interface whose functional method is
[`checkedGet`].

**`get()`**
⇒ *`R`* *(a value)*  
Produce a value, wrap checked Exceptions.

**`call()`**
⇒ *`R`*

_**`castDown(RexSupplier<? extends R, ? extends E> supplier)`**_
⇒ *`RexSupplier<R, E>`* *(`supplier` casted to the compatible parametrization [`RexSupplier`]`<R, E>`)*  
`R`: required result type  
`E`: required exception limit  
`supplier`: supplier to adopt  
Safely casts between different [`RexSupplier`] parametrization



[`BiConsumer`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BiConsumer.html
[`BiFunction`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BiFunction.html
[`BiPredicate`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BiPredicate.html
[`BooleanSupplier`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/BooleanSupplier.html
[`Consumer`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Consumer.html
[`Function`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Function.html
[`LavaBiConsumer`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabiconsumerx-y-e
[`LavaBiFunction`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabifunctionx-y-r-e
[`LavaBiPredicate`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabipredicatex-y-e
[`LavaBooleanSupplier`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabooleansuppliere
[`LavaConsumer`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavaconsumerx-e
[`LavaFunction`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavafunctionx-r-e
[`LavaPredicate`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavapredicatex-e
[`LavaRunnable`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavarunnablee
[`LavaSupplier`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavasupplierr-e
[`Predicate`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Predicate.html
[`RexBiConsumer`]: #rexbiconsumerx-y-e
[`RexBiFunction`]: #rexbifunctionx-y-r-e
[`RexBiPredicate`]: #rexbipredicatex-y-e
[`RexBooleanSupplier`]: #rexbooleansuppliere
[`RexConsumer`]: #rexconsumerx-e
[`RexFunction`]: #rexfunctionx-r-e
[`RexPredicate`]: #rexpredicatex-e
[`RexRunnable`]: #rexrunnablee
[`RexSupplier`]: #rexsupplierr-e
[`Runnable`]: https://docs.oracle.com/javase/9/docs/api/java/lang/Runnable.html
[`Supplier`]: https://docs.oracle.com/javase/9/docs/api/java/util/function/Supplier.html
[`WrappedCheckedException`]: https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception
