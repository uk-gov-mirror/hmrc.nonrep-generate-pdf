package uk.gov.hmrc.nonrep.pdfs
package model

import io.circe.Json

case class IncomingRequest(key: ApiKey, payload: Json)

case class GeneratePdfRequest(hash: PayloadHash, template: Template)

case class GeneratePdfResponse(hash: PayloadHash, pdf: PdfDocument)

case class SignPdfRequest(profile: PAdESProfile, pdf: PdfDocument, transactionId: Option[TransactionID])

case class SignPdfResponse(pdf: PdfDocument, transactionId: Option[TransactionID])