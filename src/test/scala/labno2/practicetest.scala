// package labno2
// import chisel3._
// import org.scalatest._
// import chiseltest._

// class practice1 extends FreeSpec with ChiselScalatestTester{
//     "practice1lab2" in {
//         test(new widthinference()){
//             c=>
//             c.io.x.poke(1.U)
//             c.io.y.poke(2.U)
//           //  c.io.sum.expect(4.U)
//            //  c.io.sum1.expect(3.U)
//              c.io.sumW.expect(4.U)

//         }
//     }

// }
// class practice2 extends FreeSpec with ChiselScalatestTester{
//     "practice1lab2" in {
//         test(new BitFieldManipulation()){
//             c=>
//             c.io.xMSB.poke(1.U)
//             c.io.yLowByte.poke(2.U)
//             c.io.highbyte.poke(2.U)
//           //  c.io.sum.expect(4.U)
//            //  c.io.sum1.expect(3.U)
//              c.io.address.expect(4.U)

//         }
//     }

// }