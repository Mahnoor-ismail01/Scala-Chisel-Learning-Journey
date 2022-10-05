package SingleCycle
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class jalrTest extends FreeSpec with ChiselScalatestTester{

    "jalr single cycle" in{
        test(new jalr()){
            c=>
            c.io.rs1.poke(1.S)
            c.io.rs2.poke(1.S)
            c.clock.step(1)
            c.io.jalrout.expect(2.S)        }
    }
}