tasking:
用户找小樱存包，
given普通用户找小樱存包，测量是S包，when小樱去Locker中存包，then存包成功，返回票据；
given普通用户找小樱存包，测量是M包，when小樱去PrimaryLockerRobot存包，then存包成功且按照PrimaryLockerRobot顺序存到PrimaryLockerRobot中，返回票据；
given普通用户找小樱存包，测量是L包，when小樱去SuperLockerRobot存包，then存包成功且将包存到空置率最大的存到SuperLocker中，返回票据；
givenVIP用户找小樱存包，走普通用户存包流程，测量是S包，when小樱去Locker中存包，then存包到Locker中，返回票据；
given普通用户找小樱存包，测量是S包，但是Locker满了，robot还有空位置，when小樱去Locker中存包，then提示无空间；

用户找小樱取包，
given普通用户存S包然后拿S票找小樱取包，when小樱去Locker取包，then取到用户的S包；
given普通用户存M包然后拿M票找小樱取包，when小樱去PrimaryLockerRobot取包，then取到用户的M包；
given普通用户存L包然后拿L票找小樱取包，when小樱去SuperLockerRobot取包，then取到自己的L包；
givenVIP用户之前找小樱存S包然后再拿正确的票找小樱取包，when小樱去Locker取包，then取到用户的S包；
given普通用户拿S票找小樱取包，when小樱去PrimaryLockerRobot和SuperLockerRobot找取包，then取包失败，提示票无效；
given普通用户拿假票找小樱取包，when取包，then取包失败，提示票无效；
given普通用户拿重复票找小樱取包，when取包，then取包失败，提示票无效；
givenVIP用户VIP票找小樱取包，when小樱取包，then取包失败，提示票无效；

配置Manger：
given超市管理员配置robot和Manager，when配置正确，即1个Locker，1个PrimaryLockerRobot，1个SuperLockerRobot，then配置成功；
given超市管理员配置robot和Manager，when配置正确，即1个Locker，2个PrimaryLockerRobot，then配置错误；

VIP用户存包：
givenVIP用户找manager存小包，when manager去S型Locker存包，then存包成功，返回票据；
givenVIP用户找manager存中包，when manager委任PrimaryLockerRobot存包，then存包成功，返回票据；
givenVIP用户找manager存中包，when manager自己将包存到M型号的Locker中，then存包成功，返回票据；
givenVIP用户找manager存大包，when manager委任SuperLockerRobot存包，then存包成功，返回票据；
givenVIP用户找manager存中包，when manager自己将包存到L型号的Locker中，then存包成功，返回票据；
givenVIP用户找manager存小包，S的locker满了，其他Locker未满，when manager存包，then存包失败，提示无空间；

VIP用户取包：
givenVIP用户之前存小包，找manager取包，when manager去S型Locker取包，then存包成功； 
givenVIP用户之前存中包，找manager取包，when manager去M型Locker取包，then存包成功； 
givenVIP用户之前存中包，找manager取包，when manager委任PrimaryLockerRobot取包，then存包成功； 
givenVIP用户之前存大包，找manager取包，when manager去L型Locker取包，then存包成功； 
givenVIP用户之前存大包，找manager取包，when manager去委任SuperLockerRobot取包，then存包成功；
givenVIP用户拿假票来找manager取包，when manager去取包，then提示票无效；
givenVIP用户之前找小樱存的包但是拿票来找manager取包，when manager去取包，then提示票无效；




