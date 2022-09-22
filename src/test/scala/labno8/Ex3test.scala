package labno8
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class steamin extends FreeSpec with ChiselScalatestTester{
    "ex3lab8" in {
        test(new instmemory("/home/mano/Documents/my.txt")){
            c=>
            c.io.addr.poke(4.U)
            c.clock.step(1)
            c.io.inst.expect(10.U)
        }
    }
}