package labno2
import chisel3._
import chisel3.util._

class MuxLookup1 extends Module {
val io = IO ( new Bundle {
val in0 = Input ( Bool () )
val in1 = Input ( Bool () )
val in2 = Input ( Bool () )
val in3 = Input ( Bool () )
val in4 = Input ( Bool () )
val in5 = Input ( Bool () )
val in6 = Input ( Bool () )
val in7 = Input ( Bool () )
val sel = Input ( Bool () )
val sel1 = Input ( Bool () )
val sel2 = Input ( Bool () )
val out = Output ( Bool () )
})
io . out := MuxLookup ( io.sel , false.B , Array (
    (0.B) -> MuxLookup(io.sel1,false.B,Array(
        (0. B ) -> MuxLookup(io.sel1,false.B ,Array(
            (0.B)->io.in0,
            (1.B)->io.in1
        ))
,(1. B ) -> MuxLookup(io.sel1,false.B,Array(
    (0.B)->io.in2,
    (1.B)->io.in3
))

    ))
    ,(1.B)->MuxLookup(io.sel2,false.B , Array(
        (0. B ) ->MuxLookup(io.sel2,false.B,Array(
            (0.B)->io.in4,
            (1.B)->io.in5
        ))
,(1. B ) ->MuxLookup(io.sel2,false.B,Array(
    (0.B)->io.in6,
    (1.B)->io.in7
))

    ))
))


}