package uk.gov.hmrc.nonrep.pdfs
package service

import org.scalamock.scalatest.MockFactory
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import uk.gov.hmrc.nonrep.pdfs.model.PayloadSchema

class HashCalculatorSpecs extends AnyWordSpec with Matchers with MockFactory with ScalaFutures {

  import HashCalculator.ops._
  import TestServices._

  "Hash calculator for API key" should {
    "generate api key hash" in {
      apiKey.calculateHash() shouldBe "c93ea5ce61e3e92dc024536702a7375a5f4abc85556deae83375afcc6dead40f"
    }
  }

  "Hash calculator for Payload" should {
    "generate payload hash" in {
      val template = config.templates(apiKeyHash).find(_.id == "trusts-5mld-1-0-0").get
      val payload = PayloadSchema(new String(sampleRequest_1_0_0), template.schema)
      payload.calculateHash() shouldBe "a3ebe1510e0fbca036d9b14ad8600eaa24c57eb4057dcff4e83f0e95eeee0695"
    }
  }

}
