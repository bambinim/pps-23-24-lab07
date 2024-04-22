import ex2.*

class RobotRepeatedSpec extends RobotSpec:

  override def createRobot(): Robot = new RobotRepeated((0, 0), Direction.North, 1)

  "A Robot Repeated" should "repeat its action n times" in:
    val robot = new RobotRepeated((0, 0), Direction.North, 10)
    robot.act()
    robot.position should be (0, 10)