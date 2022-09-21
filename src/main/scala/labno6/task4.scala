package labno6
import chisel3._
import chisel3.util._
class updowncounter(val max : Int=12) extends Module{
    val io= IO(new Bundle{
        val out=Output( UInt ( log2Ceil( max ) . W ) )
        val up_down=Input(Bool())


    })
    val counter=RegInit (0. U ( log2Ceil( max ) . W ) )

    when(io.up_down){
        when(counter===max.asUInt){
            counter:=counter-1.U
            io.up_down:=0.B
        }
        .otherwise{
        counter:=counter+1.U}

    }
    .otherwise{
        when(counter===0.U){
            counter:=counter+1.U
            io.up_down:=1.B
        }
        .otherwise{


        counter:=counter-1.U}

    }
    
}
