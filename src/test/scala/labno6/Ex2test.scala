package labno6
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class countertest extends FreeSpec with ChiselScalatestTester{
    "ex2lab6" in {
        test(new Counter6(8)){
            c=>
            c.clock.step(100)
            c.io.out.expect(1.U)
        }
    }
}