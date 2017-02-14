package jp._5000164.libgdx_shape

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.{Game, Gdx, Screen}
import scala.math.sin

class ShapeGame extends Game {
  override def create() {
    setScreen(new TitleScreen(this))
  }
}

class TitleScreen(game: ShapeGame) extends Screen {
  lazy val camera = new OrthographicCamera()
  camera.setToOrtho(false, 800, 480)
  lazy val shapeRenderer = new ShapeRenderer()
  var colorSeed = 0.0

  override def render(delta: Float) {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    camera.update()

    val color = sin(colorSeed)

    shapeRenderer.setProjectionMatrix(camera.combined)
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
    shapeRenderer.setColor(color.toFloat, color.toFloat, color.toFloat, 1)
    shapeRenderer.circle(340, 240, 20)
    shapeRenderer.rect(380, 220, 40, 40)
    shapeRenderer.triangle(440, 220, 480, 220, 460, 260)
    shapeRenderer.end()

    colorSeed += 0.06
  }


  override def resize(width: Int, height: Int) {}

  override def show() {}

  override def hide() {}

  override def pause() {}

  override def resume() {}

  override def dispose() {}
}