package uk.gov.hmrc.nonrep.pdfs
package model

sealed trait RequestHeader {
  def name: String
}

case object ApiKeyHeader extends RequestHeader {
  val name = "x-api-key"
}

case object TransactionIdHeader extends RequestHeader {
  val name = "x-transaction-id"
}

case object ProfileNameHeader extends RequestHeader {
  val name = "x-profile-name"
}

object HeadersConversion {
  import scala.language.implicitConversions

  implicit def convertRequestHeader(header: RequestHeader) = header.name
}
