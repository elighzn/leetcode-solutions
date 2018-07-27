package dummy;

public class Dummy {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String ps = "SELECT " + "  startDate.value operation_date, "
        + "  endDate.value settlement_date, "
        + "  property6  || '_'  || r.invoice_type Settlement_type, "
        + "  DECODE(SUBSTR(r.settlement_type, 0, 3), 'Pre', 'Pre_' || r.settlement_from, r.settlement_from) SETTLEMENT_FROM, "
        + "  r.invoice_date INVOICE_DATE, " + "  g.name Asset_owner, " + "  '_ALL' key_name, "
        + "  '_TOTAL' key_type, " + "  'ALL_DOLLAR' CALC_TYPE_NAME, " + "  d.bind_name, "
        + "  sum(d.total) TOTAL, " + "  '' calc_type_data1, " + "  '' calc_type_data2 , "
        + "  invoiceDueDate.value invoiceDueDate, "
        + "  invoiceReceiptDate.value invoiceReceiptDate, " + "  startDate.value startDate, "
        + "  endDate.value endDate " + "FROM  " + "  scalc_result r, " + "  scalc_set s, "
        + "  scalc_result_attr startDate,  " + "  scalc_result_attr endDate,  "
        + "  scalc_result_attr invoiceDueDate, " + "  scalc_result_attr invoiceReceiptDate, "
        + "  scalc_result_group g, " + "  scalc_type t, "
        + "  scalc_type_data#{dts,replace=true}  d, " + "  scalc_key k " + "WHERE "
        + "  r.calc_result_key = startDate.calc_result_key" + "  AND startDate.id = 'startDate' "
        + "  AND r.calc_result_key = endDate.calc_result_key" + "  AND endDate.id = 'endDate' "
        + "  AND r.calc_result_key = invoiceDueDate.calc_result_key(+)"
        + "  AND invoiceDueDate.id(+) = 'invoiceDueDate' "
        + "  AND r.calc_result_key = invoiceReceiptDate.calc_result_key(+)"
        + "  AND invoiceReceiptDate.id(+) = 'invoiceReceiptDate' "
        + "  AND r.calc_set_key = s.calc_set_key" + "  AND s.name = #{calcSetName} "
        + "  AND g.calc_result_key = r.calc_result_key  "
        + "  AND g.calc_result_group_key = d.calc_result_group_key "
        + "  AND d.calc_type_key = t.calc_type_key "
        + "  AND t.name in ('CAISO.TOTAL_CHARGES3','CAISO.TOTAL_CHARGES2','CAISO.TOTAL_CHARGES1', 'CAISO.TOTAL_CHARGES5', 'CAISO.TOTAL_CHARGES6')"
        + "  AND d.bind_name = '_Incremental' "
        + "  AND r.invoice_date BETWEEN #{startDate} AND #{endDate} "
        + "  AND k.calc_key_key = d.calc_key_key "
        + "  AND k.name = '_ALL' AND k.key_type = '_TOTAL' "
        + "  #{assetOwner,pre=AND g.NAME in(,inClause=5,post=)} " + "  AND property6 != ' ' "
        + " group by  " + "  t.property6, " + "  r.invoice_date, "
        + "  DECODE(SUBSTR(r.settlement_type, 0, 3), 'Pre', 'Pre_' || r.settlement_from, r.settlement_from)  , "
        + "  r.invoice_type, " + "  r.settlement_from , " + "  startDate.value, "
        + "  endDate.value, " + "  invoiceDueDate.value , " + "  invoiceReceiptDate.value , "
        + "  g.name, " + "  d.bind_name /* CAISO_SQL 17*/";

    // System.out.println(ps);

    int bitmask = 0x000F;
    int val = 3;
    System.out.println(val);

    
    val = val << 2;
    System.out.println(val);
    
    val = val >> 1;
    System.out.println(val);
  }

}
