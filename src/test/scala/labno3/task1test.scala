package labno3
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class Immediatetest extends FreeSpec with ChiselScalatestTester{
    "testlabno6" in {
        test(new ImmdValGen()).withAnnotations(Seq(VerilatorBackendAnnotation)){
            c=>
            c.io.instr.poke("h918093".U)
            
            c.clock.step(10)
            //c.io.immd_se.expect(9.U)
        }
    }
}