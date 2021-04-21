# Slider bug in compose: onValueChangeFinish called twice

## Expected behavior
`onValueChangeFinish` is called once after the user has finished dragging a slider.

## Actual behavior
`onValueChangeFinish` is called twice. A first time immediately once the user starts dragging a slider and second time once the user has finished dragging the slider.

## Snippet used
[SliderScreen.kt](app/src/main/java/dev/berggren/SliderScreen.kt):
```
@Composable
fun SliderScreen() {
    var callCounter by remember { mutableStateOf(0) }
    var value by remember { mutableStateOf(0f) }
    Slider(
        value = value,
        onValueChange = { value = it },
        onValueChangeFinished = {
            callCounter += 1
            println("onValueChangeFinished called $callCounter times")
        }
    )
}
```

## Log output
```
I/System.out: onValueChangeFinished called 1 times
I/System.out: onValueChangeFinished called 2 times
```

