import ex2.*

class RobotWithBatterySpec extends RobotSpec:

  override def createRobot(): Robot = new RobotWithBattery((0, 0), Direction.North, 100, 1)

  "A Robot With Battery" should "consume battery" in:
    val robot = new RobotWithBattery((0, 0), Direction.North, 10, 5)
    robot.turn(Direction.South)
    robot.act()
    robot.batteryLevel should be (5)

  it should "not be able to move when battery level is low" in:
    val robot = new RobotWithBattery((0, 0), Direction.North, 10, 5)
    robot.turn(Direction.South)
    robot.act()
    robot.act()
    val positionBeforeAct = robot.position
    robot.act()
    robot.position should be (positionBeforeAct)