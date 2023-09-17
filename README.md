# Logic Freaks Backend Challenge Microservice

## Beschreibung
Dieser Microservice wurde entwickelt, um eine spezialisierte Lösung für die "Logic Freaks Backend Challenge" bereitzustellen. Die Hauptaufgabe dieses Microservices besteht darin, Echtzeit-Rechnungsprognosen basierend auf den Daten der letzten 12 Monate bereitzustellen.

## Technologie
Dieser Microservice wurde mit Spring Boot 3.1 und Java entwickelt.

## Funktionen
- Kommunikation mit der externen "API-Billing" API
- Grafische Darstellung der Rechnungen der letzten 12 Monate sowie einer aktuellen Prognose:
  - Abrufen der Grafik (GET /invoice/getInvoiceGraphic)
- Export von Rechnungsdaten in eine Excel-Datei:
  - Export starten (POST /invoice/export)
- Vorhersage von Rechnungsdaten:
  - Vorhersage (Forecast) abrufen (GET /forecast/getForecast)

## Konfiguration
Der Microservice ist konfigurierbar über eine Config-Datei. Die Konfigurationsparameter müssen angepasst werden:

```properties
[challengeForecastService]=
forecast.timeframe=12
# Für den Dateiexport (muss in Windows-Umgebung escapet werden)
local.destination.path=##LocalPath##
local.destination.filename=InvoicesList.csv
# Grafikdimensionen (in Pixel)
invoice.graphic.height=1200
invoice.graphic.width=1400

[API-Billing-API]=
billing.api.url=URL-HIER
billing.api.authenticationUrl=URL-HIER
billing.api.grantType=GRANT-TYP-HIER
billing.api.clientId=CLIENT-ID-HIER
billing.api.clientSecret=CLIENT-SECRET-HIER
billing.api.user=USER-HIER
billing.api.password=PASSWORT-HIER
billing.api.invoiceListEndpoint=ENDPUNKT-HIER

## Dateiexport
Es gibt eine Funktion, um Daten wie Rechnungsnummer, Rechnungsdatum und andere relevante Informationen der Rechnungseigenschaften in eine Excel-Datei zu exportieren.
