package com.micro_services.micro_services_demo.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.micro_services.micro_services_demo.model.Invoice;
import com.micro_services.micro_services_demo.model.Product;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class InvoiceService {

    public byte[] createInvoicePdf(Invoice invoice) throws DocumentException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        document.add(new Paragraph("Invoice"));
        document.add(new Paragraph("Invoice Number: " + invoice.getInvoiceNumber()));
        document.add(new Paragraph("Customer Name: " + invoice.getCustomerName()));
        document.add(new Paragraph("Date: " + invoice.getDate()));
        document.add(new Paragraph("\nItems: "));

        double totalAmount = 0;
        for (Product product : invoice.getProducts()) {
            double totalProductCost = product.getAmount() * product.getQuantity();
            double taxAmount = totalProductCost * (product.getTaxPercentage() / 100);
            double finalCost = totalProductCost + taxAmount;
            totalAmount += finalCost;
            document.add(new Paragraph(product.getName() + " - " + product.getQuantity() + " x " + product.getAmount() + " + Tax(" + product.getTaxPercentage() + "%) = " + finalCost));
        }

        document.add(new Paragraph("\nTotal Amount: " + totalAmount));
        document.close();
        return outputStream.toByteArray();
    }
}
