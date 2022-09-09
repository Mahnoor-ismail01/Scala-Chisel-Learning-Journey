package labno2
import chisel3._
import org.scalatest._
import chiseltest._

class Mux_5to1test extends FreeSpec with ChiselScalatestTester{
    "testlabno2" in{
        test(new Mux_5to1()){
            c=>
            c.io.in1.poke(24.U)
            c.io.in2.poke(16.U)
            c.io.in3.poke(32.U)
            c.io.in4.poke(0.U)
            c.io.in5.poke(8.U)
            c.io.s0.poke(1.B)
            c.io.s1.poke(0.B)
            c.io.s2.poke(0.B)
            c.clock.step(1)
            c.io.out.expect(32.U)

        }
    }
}