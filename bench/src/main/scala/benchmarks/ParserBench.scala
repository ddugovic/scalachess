package benchmarks

import org.openjdk.jmh.annotations._

import cats.syntax.all.*

import chess.PerftTestCase

import java.util.concurrent.TimeUnit
import chess.format.pgn.Fixtures
import chess.format.pgn.Parser

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.Throughput))
@OutputTimeUnit(TimeUnit.SECONDS)
@Measurement(iterations = 15, timeUnit = TimeUnit.SECONDS, time = 3)
@Warmup(iterations = 15, timeUnit = TimeUnit.SECONDS, time = 3)
@Threads(value = 1)
class ParserBench {

  @Benchmark
  def PgnParser(): Boolean =
    Fixtures.gamesForPerfTest.traverse(Parser.full).isValid

}
