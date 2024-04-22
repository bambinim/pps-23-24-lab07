import ex2.*

class RobotCanFailSpec extends RobotSpec:

  override def createRobot(): Robot = new RobotCanFail((0, 0), Direction.North, 0)

  "A Robot with failure probability" should "never fail with probability 0%" in:
    val robot: Robot = new RobotCanFail((0, 0), Direction.South, 0)
    for i <- 1 to 10 do
      val position = robot.position
      robot.act()
      robot.position should not be (position)

  it should "always fail with probability 100%" in:
    val robot: Robot = new RobotCanFail((0, 0), Direction.South, 100)
    val position = robot.position
    for i <- 1 to 10 do
      robot.act()
      robot.position should be (position)

  it should "fail sometimes with probability 50%" in:
    val robot: Robot = new RobotCanFail((0, 0), Direction.South, 50)
    val attempts = 10
    var failures = 0
    for i <- 1 to attempts do
      val position = robot.position
      robot.act()
      if position == robot.position then failures += 1
    failures should be > 0
    failures should be < attempts