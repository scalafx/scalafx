ScalaFX is a UI DSL written within the Scala Language that sits on top of JavaFX. This means that every ScalaFX
application is also a valid Scala application. By extension, it supports full interoperability with Java and can run
anywhere the Java Virtual Machine (JVM)
and JavaFX are supported.

## Package Structure

ScalaFX package structure corresponds to JavaFX package structure, for instance [[scalafx.animation
`scalafx.animation`]] corresponds to `javafx.animation`.

## Example Usage

A basic ScalaFX application is created creating an object that is an instance of [[scalafx.application.JFXApp3
`JFXApp3`]]. Following Java FX theatre metaphor, it contains a `stage` that contains a `scene`. A `stage` roughly
corresponds to a window in a typical UI environment. The `scene` holds UI content presented to the user. In the example
below, the content is a pane with a single `label` component.

```scala 3
import scalafx.application.JFXApp3
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Label
import scalafx.scene.layout.BorderPane

object HelloWorld extends JFXApp3:
  override def start(): Unit =
    stage = new JFXApp3.PrimaryStage:
      title = "Hello"
      scene = new Scene:
        root = new BorderPane:
          padding = Insets(75)
          center = new Label("Hello World")
```

## Additional Documentation

For more information visit the [ScalaFX](https://scalafx.org) website.