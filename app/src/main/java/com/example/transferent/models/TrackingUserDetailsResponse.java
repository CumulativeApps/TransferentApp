package com.example.transferent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackingUserDetailsResponse {

    @SerializedName("data")
    @Expose
    public Data data;
    @SerializedName("message")
    @Expose
    public String message;

    public TrackingUserDetailsResponse withData(Data data) {
        this.data = data;
        return this;
    }

    public TrackingUserDetailsResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Data {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("uid")
        @Expose
        public String uid;
        @SerializedName("user_id")
        @Expose
        public Integer userId;
        @SerializedName("tracking_number")
        @Expose
        public Object trackingNumber;
        @SerializedName("tracking_id")
        @Expose
        public String trackingId;
        @SerializedName("ritm_incident_number")
        @Expose
        public String ritmIncidentNumber;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("vendor")
        @Expose
        public Object vendor;
        @SerializedName("wpn")
        @Expose
        public Object wpn;
        @SerializedName("candidate_id")
        @Expose
        public Object candidateId;
        @SerializedName("eid")
        @Expose
        public String eid;
        @SerializedName("serial_number")
        @Expose
        public String serialNumber;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("mobile")
        @Expose
        public String mobile;
        @SerializedName("remarks")
        @Expose
        public String remarks;
        @SerializedName("pod_img")
        @Expose
        public Object podImg;
        @SerializedName("remarks_updated_at")
        @Expose
        public Object remarksUpdatedAt;
        @SerializedName("eta")
        @Expose
        public Object eta;
        @SerializedName("pincode")
        @Expose
        public String pincode;
        @SerializedName("actual_pincode")
        @Expose
        public String actualPincode;
        @SerializedName("date_of_delivery")
        @Expose
        public Object dateOfDelivery;
        @SerializedName("company_name")
        @Expose
        public String companyName;
        @SerializedName("company_origin")
        @Expose
        public String companyOrigin;
        @SerializedName("comment")
        @Expose
        public Object comment;
        @SerializedName("return_to_location")
        @Expose
        public Object returnToLocation;
        @SerializedName("return_to_client_location_date")
        @Expose
        public Object returnToClientLocationDate;
        @SerializedName("reference_sheet")
        @Expose
        public Object referenceSheet;
        @SerializedName("pickup_location")
        @Expose
        public Object pickupLocation;
        @SerializedName("delivery_type")
        @Expose
        public String deliveryType;
        @SerializedName("otp")
        @Expose
        public Integer otp;
        @SerializedName("eta_date")
        @Expose
        public Object etaDate;
        @SerializedName("po_type")
        @Expose
        public String poType;
        @SerializedName("reject_reason")
        @Expose
        public Object rejectReason;
        @SerializedName("reschedule_reason")
        @Expose
        public Object rescheduleReason;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public Object updatedAt;
        @SerializedName("po_number")
        @Expose
        public Object poNumber;
        @SerializedName("postal_address")
        @Expose
        public String postalAddress;
        @SerializedName("destination_city")
        @Expose
        public Object destinationCity;
        @SerializedName("destination_state")
        @Expose
        public Object destinationState;
        @SerializedName("po_opening_date")
        @Expose
        public Object poOpeningDate;
        @SerializedName("po_expiry_date")
        @Expose
        public Object poExpiryDate;
        @SerializedName("location_info")
        @Expose
        public Object locationInfo;
        @SerializedName("eta_delivery_date")
        @Expose
        public Object etaDeliveryDate;
        @SerializedName("actual_delivery_date")
        @Expose
        public String actualDeliveryDate;
        @SerializedName("pricing")
        @Expose
        public Object pricing;
        @SerializedName("bill_date")
        @Expose
        public Object billDate;
        @SerializedName("invoice_no")
        @Expose
        public Object invoiceNo;
        @SerializedName("asset_picked_up_date")
        @Expose
        public Object assetPickedUpDate;
        @SerializedName("asset_dispatch_date")
        @Expose
        public Object assetDispatchDate;
        @SerializedName("re_route_date")
        @Expose
        public Object reRouteDate;
        @SerializedName("revise_rerouted_address")
        @Expose
        public Object reviseReroutedAddress;
        @SerializedName("aging")
        @Expose
        public Object aging;
        @SerializedName("status")
        @Expose
        public Object status;
        @SerializedName("reason")
        @Expose
        public Object reason;
        @SerializedName("rerouted")
        @Expose
        public Object rerouted;
        @SerializedName("dxc_site_name")
        @Expose
        public String dxcSiteName;
        @SerializedName("pickup_city")
        @Expose
        public String pickupCity;
        @SerializedName("pickup_state")
        @Expose
        public Object pickupState;
        @SerializedName("asset_type")
        @Expose
        public String assetType;
        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("delivered_date")
        @Expose
        public Object deliveredDate;
        @SerializedName("pickup_date")
        @Expose
        public Object pickupDate;
        @SerializedName("bill_re_routed_charges")
        @Expose
        public Object billReRoutedCharges;
        @SerializedName("bill_rto_charges")
        @Expose
        public Object billRtoCharges;
        @SerializedName("accessories_cost")
        @Expose
        public Object accessoriesCost;
        @SerializedName("packing_cost")
        @Expose
        public Object packingCost;
        @SerializedName("total_cost")
        @Expose
        public Object totalCost;
        @SerializedName("other_cost")
        @Expose
        public Object otherCost;
        @SerializedName("payment_status")
        @Expose
        public Object paymentStatus;
        @SerializedName("trs_move_cordinator")
        @Expose
        public Object trsMoveCordinator;
        @SerializedName("date_of_exit")
        @Expose
        public Object dateOfExit;
        @SerializedName("acknowledgement_share_date")
        @Expose
        public Object acknowledgementShareDate;
        @SerializedName("asset_description")
        @Expose
        public Object assetDescription;
        @SerializedName("asset_s_n")
        @Expose
        public Object assetSN;
        @SerializedName("rto_date")
        @Expose
        public Object rtoDate;
        @SerializedName("ack_image_one")
        @Expose
        public Object ackImageOne;
        @SerializedName("ack_image_two")
        @Expose
        public Object ackImageTwo;
        @SerializedName("delivery_status")
        @Expose
        public Object deliveryStatus;
        @SerializedName("delivery_status_date")
        @Expose
        public Object deliveryStatusDate;
        @SerializedName("temp")
        @Expose
        public Integer temp;
        @SerializedName("pod_image")
        @Expose
        public Object podImage;
        @SerializedName("expected_pickup_date")
        @Expose
        public Object expectedPickupDate;
        @SerializedName("future_delivery_date")
        @Expose
        public Object futureDeliveryDate;
        @SerializedName("assets_collected")
        @Expose
        public Object assetsCollected;
        @SerializedName("new_category")
        @Expose
        public String newCategory;

        public Data withId(Integer id) {
            this.id = id;
            return this;
        }

        public Data withUid(String uid) {
            this.uid = uid;
            return this;
        }

        public Data withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Data withTrackingNumber(Object trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }

        public Data withTrackingId(String trackingId) {
            this.trackingId = trackingId;
            return this;
        }

        public Data withRitmIncidentNumber(String ritmIncidentNumber) {
            this.ritmIncidentNumber = ritmIncidentNumber;
            return this;
        }

        public Data withEmail(String email) {
            this.email = email;
            return this;
        }

        public Data withVendor(Object vendor) {
            this.vendor = vendor;
            return this;
        }

        public Data withWpn(Object wpn) {
            this.wpn = wpn;
            return this;
        }

        public Data withCandidateId(Object candidateId) {
            this.candidateId = candidateId;
            return this;
        }

        public Data withEid(String eid) {
            this.eid = eid;
            return this;
        }

        public Data withSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public Data withName(String name) {
            this.name = name;
            return this;
        }

        public Data withMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Data withRemarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Data withPodImg(Object podImg) {
            this.podImg = podImg;
            return this;
        }

        public Data withRemarksUpdatedAt(Object remarksUpdatedAt) {
            this.remarksUpdatedAt = remarksUpdatedAt;
            return this;
        }

        public Data withEta(Object eta) {
            this.eta = eta;
            return this;
        }

        public Data withPincode(String pincode) {
            this.pincode = pincode;
            return this;
        }

        public Data withActualPincode(String actualPincode) {
            this.actualPincode = actualPincode;
            return this;
        }

        public Data withDateOfDelivery(Object dateOfDelivery) {
            this.dateOfDelivery = dateOfDelivery;
            return this;
        }

        public Data withCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Data withCompanyOrigin(String companyOrigin) {
            this.companyOrigin = companyOrigin;
            return this;
        }

        public Data withComment(Object comment) {
            this.comment = comment;
            return this;
        }

        public Data withReturnToLocation(Object returnToLocation) {
            this.returnToLocation = returnToLocation;
            return this;
        }

        public Data withReturnToClientLocationDate(Object returnToClientLocationDate) {
            this.returnToClientLocationDate = returnToClientLocationDate;
            return this;
        }

        public Data withReferenceSheet(Object referenceSheet) {
            this.referenceSheet = referenceSheet;
            return this;
        }

        public Data withPickupLocation(Object pickupLocation) {
            this.pickupLocation = pickupLocation;
            return this;
        }

        public Data withDeliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
            return this;
        }

        public Data withOtp(Integer otp) {
            this.otp = otp;
            return this;
        }

        public Data withEtaDate(Object etaDate) {
            this.etaDate = etaDate;
            return this;
        }

        public Data withPoType(String poType) {
            this.poType = poType;
            return this;
        }

        public Data withRejectReason(Object rejectReason) {
            this.rejectReason = rejectReason;
            return this;
        }

        public Data withRescheduleReason(Object rescheduleReason) {
            this.rescheduleReason = rescheduleReason;
            return this;
        }

        public Data withCreatedAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Data withUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Data withPoNumber(Object poNumber) {
            this.poNumber = poNumber;
            return this;
        }

        public Data withPostalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }

        public Data withDestinationCity(Object destinationCity) {
            this.destinationCity = destinationCity;
            return this;
        }

        public Data withDestinationState(Object destinationState) {
            this.destinationState = destinationState;
            return this;
        }

        public Data withPoOpeningDate(Object poOpeningDate) {
            this.poOpeningDate = poOpeningDate;
            return this;
        }

        public Data withPoExpiryDate(Object poExpiryDate) {
            this.poExpiryDate = poExpiryDate;
            return this;
        }

        public Data withLocationInfo(Object locationInfo) {
            this.locationInfo = locationInfo;
            return this;
        }

        public Data withEtaDeliveryDate(Object etaDeliveryDate) {
            this.etaDeliveryDate = etaDeliveryDate;
            return this;
        }

        public Data withActualDeliveryDate(String actualDeliveryDate) {
            this.actualDeliveryDate = actualDeliveryDate;
            return this;
        }

        public Data withPricing(Object pricing) {
            this.pricing = pricing;
            return this;
        }

        public Data withBillDate(Object billDate) {
            this.billDate = billDate;
            return this;
        }

        public Data withInvoiceNo(Object invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }

        public Data withAssetPickedUpDate(Object assetPickedUpDate) {
            this.assetPickedUpDate = assetPickedUpDate;
            return this;
        }

        public Data withAssetDispatchDate(Object assetDispatchDate) {
            this.assetDispatchDate = assetDispatchDate;
            return this;
        }

        public Data withReRouteDate(Object reRouteDate) {
            this.reRouteDate = reRouteDate;
            return this;
        }

        public Data withReviseReroutedAddress(Object reviseReroutedAddress) {
            this.reviseReroutedAddress = reviseReroutedAddress;
            return this;
        }

        public Data withAging(Object aging) {
            this.aging = aging;
            return this;
        }

        public Data withStatus(Object status) {
            this.status = status;
            return this;
        }

        public Data withReason(Object reason) {
            this.reason = reason;
            return this;
        }

        public Data withRerouted(Object rerouted) {
            this.rerouted = rerouted;
            return this;
        }

        public Data withDxcSiteName(String dxcSiteName) {
            this.dxcSiteName = dxcSiteName;
            return this;
        }

        public Data withPickupCity(String pickupCity) {
            this.pickupCity = pickupCity;
            return this;
        }

        public Data withPickupState(Object pickupState) {
            this.pickupState = pickupState;
            return this;
        }

        public Data withAssetType(String assetType) {
            this.assetType = assetType;
            return this;
        }

        public Data withType(String type) {
            this.type = type;
            return this;
        }

        public Data withDeliveredDate(Object deliveredDate) {
            this.deliveredDate = deliveredDate;
            return this;
        }

        public Data withPickupDate(Object pickupDate) {
            this.pickupDate = pickupDate;
            return this;
        }

        public Data withBillReRoutedCharges(Object billReRoutedCharges) {
            this.billReRoutedCharges = billReRoutedCharges;
            return this;
        }

        public Data withBillRtoCharges(Object billRtoCharges) {
            this.billRtoCharges = billRtoCharges;
            return this;
        }

        public Data withAccessoriesCost(Object accessoriesCost) {
            this.accessoriesCost = accessoriesCost;
            return this;
        }

        public Data withPackingCost(Object packingCost) {
            this.packingCost = packingCost;
            return this;
        }

        public Data withTotalCost(Object totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Data withOtherCost(Object otherCost) {
            this.otherCost = otherCost;
            return this;
        }

        public Data withPaymentStatus(Object paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Data withTrsMoveCordinator(Object trsMoveCordinator) {
            this.trsMoveCordinator = trsMoveCordinator;
            return this;
        }

        public Data withDateOfExit(Object dateOfExit) {
            this.dateOfExit = dateOfExit;
            return this;
        }

        public Data withAcknowledgementShareDate(Object acknowledgementShareDate) {
            this.acknowledgementShareDate = acknowledgementShareDate;
            return this;
        }

        public Data withAssetDescription(Object assetDescription) {
            this.assetDescription = assetDescription;
            return this;
        }

        public Data withAssetSN(Object assetSN) {
            this.assetSN = assetSN;
            return this;
        }

        public Data withRtoDate(Object rtoDate) {
            this.rtoDate = rtoDate;
            return this;
        }

        public Data withAckImageOne(Object ackImageOne) {
            this.ackImageOne = ackImageOne;
            return this;
        }

        public Data withAckImageTwo(Object ackImageTwo) {
            this.ackImageTwo = ackImageTwo;
            return this;
        }

        public Data withDeliveryStatus(Object deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
            return this;
        }

        public Data withDeliveryStatusDate(Object deliveryStatusDate) {
            this.deliveryStatusDate = deliveryStatusDate;
            return this;
        }

        public Data withTemp(Integer temp) {
            this.temp = temp;
            return this;
        }

        public Data withPodImage(Object podImage) {
            this.podImage = podImage;
            return this;
        }

        public Data withExpectedPickupDate(Object expectedPickupDate) {
            this.expectedPickupDate = expectedPickupDate;
            return this;
        }

        public Data withFutureDeliveryDate(Object futureDeliveryDate) {
            this.futureDeliveryDate = futureDeliveryDate;
            return this;
        }

        public Data withAssetsCollected(Object assetsCollected) {
            this.assetsCollected = assetsCollected;
            return this;
        }

        public Data withNewCategory(String newCategory) {
            this.newCategory = newCategory;
            return this;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Object getTrackingNumber() {
            return trackingNumber;
        }

        public void setTrackingNumber(Object trackingNumber) {
            this.trackingNumber = trackingNumber;
        }

        public String getTrackingId() {
            return trackingId;
        }

        public void setTrackingId(String trackingId) {
            this.trackingId = trackingId;
        }

        public String getRitmIncidentNumber() {
            return ritmIncidentNumber;
        }

        public void setRitmIncidentNumber(String ritmIncidentNumber) {
            this.ritmIncidentNumber = ritmIncidentNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getVendor() {
            return vendor;
        }

        public void setVendor(Object vendor) {
            this.vendor = vendor;
        }

        public Object getWpn() {
            return wpn;
        }

        public void setWpn(Object wpn) {
            this.wpn = wpn;
        }

        public Object getCandidateId() {
            return candidateId;
        }

        public void setCandidateId(Object candidateId) {
            this.candidateId = candidateId;
        }

        public String getEid() {
            return eid;
        }

        public void setEid(String eid) {
            this.eid = eid;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public Object getPodImg() {
            return podImg;
        }

        public void setPodImg(Object podImg) {
            this.podImg = podImg;
        }

        public Object getRemarksUpdatedAt() {
            return remarksUpdatedAt;
        }

        public void setRemarksUpdatedAt(Object remarksUpdatedAt) {
            this.remarksUpdatedAt = remarksUpdatedAt;
        }

        public Object getEta() {
            return eta;
        }

        public void setEta(Object eta) {
            this.eta = eta;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getActualPincode() {
            return actualPincode;
        }

        public void setActualPincode(String actualPincode) {
            this.actualPincode = actualPincode;
        }

        public Object getDateOfDelivery() {
            return dateOfDelivery;
        }

        public void setDateOfDelivery(Object dateOfDelivery) {
            this.dateOfDelivery = dateOfDelivery;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyOrigin() {
            return companyOrigin;
        }

        public void setCompanyOrigin(String companyOrigin) {
            this.companyOrigin = companyOrigin;
        }

        public Object getComment() {
            return comment;
        }

        public void setComment(Object comment) {
            this.comment = comment;
        }

        public Object getReturnToLocation() {
            return returnToLocation;
        }

        public void setReturnToLocation(Object returnToLocation) {
            this.returnToLocation = returnToLocation;
        }

        public Object getReturnToClientLocationDate() {
            return returnToClientLocationDate;
        }

        public void setReturnToClientLocationDate(Object returnToClientLocationDate) {
            this.returnToClientLocationDate = returnToClientLocationDate;
        }

        public Object getReferenceSheet() {
            return referenceSheet;
        }

        public void setReferenceSheet(Object referenceSheet) {
            this.referenceSheet = referenceSheet;
        }

        public Object getPickupLocation() {
            return pickupLocation;
        }

        public void setPickupLocation(Object pickupLocation) {
            this.pickupLocation = pickupLocation;
        }

        public String getDeliveryType() {
            return deliveryType;
        }

        public void setDeliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
        }

        public Integer getOtp() {
            return otp;
        }

        public void setOtp(Integer otp) {
            this.otp = otp;
        }

        public Object getEtaDate() {
            return etaDate;
        }

        public void setEtaDate(Object etaDate) {
            this.etaDate = etaDate;
        }

        public String getPoType() {
            return poType;
        }

        public void setPoType(String poType) {
            this.poType = poType;
        }

        public Object getRejectReason() {
            return rejectReason;
        }

        public void setRejectReason(Object rejectReason) {
            this.rejectReason = rejectReason;
        }

        public Object getRescheduleReason() {
            return rescheduleReason;
        }

        public void setRescheduleReason(Object rescheduleReason) {
            this.rescheduleReason = rescheduleReason;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Object getPoNumber() {
            return poNumber;
        }

        public void setPoNumber(Object poNumber) {
            this.poNumber = poNumber;
        }

        public String getPostalAddress() {
            return postalAddress;
        }

        public void setPostalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
        }

        public Object getDestinationCity() {
            return destinationCity;
        }

        public void setDestinationCity(Object destinationCity) {
            this.destinationCity = destinationCity;
        }

        public Object getDestinationState() {
            return destinationState;
        }

        public void setDestinationState(Object destinationState) {
            this.destinationState = destinationState;
        }

        public Object getPoOpeningDate() {
            return poOpeningDate;
        }

        public void setPoOpeningDate(Object poOpeningDate) {
            this.poOpeningDate = poOpeningDate;
        }

        public Object getPoExpiryDate() {
            return poExpiryDate;
        }

        public void setPoExpiryDate(Object poExpiryDate) {
            this.poExpiryDate = poExpiryDate;
        }

        public Object getLocationInfo() {
            return locationInfo;
        }

        public void setLocationInfo(Object locationInfo) {
            this.locationInfo = locationInfo;
        }

        public Object getEtaDeliveryDate() {
            return etaDeliveryDate;
        }

        public void setEtaDeliveryDate(Object etaDeliveryDate) {
            this.etaDeliveryDate = etaDeliveryDate;
        }

        public Object getActualDeliveryDate() {
            return actualDeliveryDate;
        }

        public void setActualDeliveryDate(String actualDeliveryDate) {
            this.actualDeliveryDate = actualDeliveryDate;
        }

        public Object getPricing() {
            return pricing;
        }

        public void setPricing(Object pricing) {
            this.pricing = pricing;
        }

        public Object getBillDate() {
            return billDate;
        }

        public void setBillDate(Object billDate) {
            this.billDate = billDate;
        }

        public Object getInvoiceNo() {
            return invoiceNo;
        }

        public void setInvoiceNo(Object invoiceNo) {
            this.invoiceNo = invoiceNo;
        }

        public Object getAssetPickedUpDate() {
            return assetPickedUpDate;
        }

        public void setAssetPickedUpDate(Object assetPickedUpDate) {
            this.assetPickedUpDate = assetPickedUpDate;
        }

        public Object getAssetDispatchDate() {
            return assetDispatchDate;
        }

        public void setAssetDispatchDate(Object assetDispatchDate) {
            this.assetDispatchDate = assetDispatchDate;
        }

        public Object getReRouteDate() {
            return reRouteDate;
        }

        public void setReRouteDate(Object reRouteDate) {
            this.reRouteDate = reRouteDate;
        }

        public Object getReviseReroutedAddress() {
            return reviseReroutedAddress;
        }

        public void setReviseReroutedAddress(Object reviseReroutedAddress) {
            this.reviseReroutedAddress = reviseReroutedAddress;
        }

        public Object getAging() {
            return aging;
        }

        public void setAging(Object aging) {
            this.aging = aging;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public Object getReason() {
            return reason;
        }

        public void setReason(Object reason) {
            this.reason = reason;
        }

        public Object getRerouted() {
            return rerouted;
        }

        public void setRerouted(Object rerouted) {
            this.rerouted = rerouted;
        }

        public String getDxcSiteName() {
            return dxcSiteName;
        }

        public void setDxcSiteName(String dxcSiteName) {
            this.dxcSiteName = dxcSiteName;
        }

        public String getPickupCity() {
            return pickupCity;
        }

        public void setPickupCity(String pickupCity) {
            this.pickupCity = pickupCity;
        }

        public Object getPickupState() {
            return pickupState;
        }

        public void setPickupState(Object pickupState) {
            this.pickupState = pickupState;
        }

        public String getAssetType() {
            return assetType;
        }

        public void setAssetType(String assetType) {
            this.assetType = assetType;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getDeliveredDate() {
            return deliveredDate;
        }

        public void setDeliveredDate(Object deliveredDate) {
            this.deliveredDate = deliveredDate;
        }

        public Object getPickupDate() {
            return pickupDate;
        }

        public void setPickupDate(Object pickupDate) {
            this.pickupDate = pickupDate;
        }

        public Object getBillReRoutedCharges() {
            return billReRoutedCharges;
        }

        public void setBillReRoutedCharges(Object billReRoutedCharges) {
            this.billReRoutedCharges = billReRoutedCharges;
        }

        public Object getBillRtoCharges() {
            return billRtoCharges;
        }

        public void setBillRtoCharges(Object billRtoCharges) {
            this.billRtoCharges = billRtoCharges;
        }

        public Object getAccessoriesCost() {
            return accessoriesCost;
        }

        public void setAccessoriesCost(Object accessoriesCost) {
            this.accessoriesCost = accessoriesCost;
        }

        public Object getPackingCost() {
            return packingCost;
        }

        public void setPackingCost(Object packingCost) {
            this.packingCost = packingCost;
        }

        public Object getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(Object totalCost) {
            this.totalCost = totalCost;
        }

        public Object getOtherCost() {
            return otherCost;
        }

        public void setOtherCost(Object otherCost) {
            this.otherCost = otherCost;
        }

        public Object getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(Object paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public Object getTrsMoveCordinator() {
            return trsMoveCordinator;
        }

        public void setTrsMoveCordinator(Object trsMoveCordinator) {
            this.trsMoveCordinator = trsMoveCordinator;
        }

        public Object getDateOfExit() {
            return dateOfExit;
        }

        public void setDateOfExit(Object dateOfExit) {
            this.dateOfExit = dateOfExit;
        }

        public Object getAcknowledgementShareDate() {
            return acknowledgementShareDate;
        }

        public void setAcknowledgementShareDate(Object acknowledgementShareDate) {
            this.acknowledgementShareDate = acknowledgementShareDate;
        }

        public Object getAssetDescription() {
            return assetDescription;
        }

        public void setAssetDescription(Object assetDescription) {
            this.assetDescription = assetDescription;
        }

        public Object getAssetSN() {
            return assetSN;
        }

        public void setAssetSN(Object assetSN) {
            this.assetSN = assetSN;
        }

        public Object getRtoDate() {
            return rtoDate;
        }

        public void setRtoDate(Object rtoDate) {
            this.rtoDate = rtoDate;
        }

        public Object getAckImageOne() {
            return ackImageOne;
        }

        public void setAckImageOne(Object ackImageOne) {
            this.ackImageOne = ackImageOne;
        }

        public Object getAckImageTwo() {
            return ackImageTwo;
        }

        public void setAckImageTwo(Object ackImageTwo) {
            this.ackImageTwo = ackImageTwo;
        }

        public Object getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(Object deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }

        public Object getDeliveryStatusDate() {
            return deliveryStatusDate;
        }

        public void setDeliveryStatusDate(Object deliveryStatusDate) {
            this.deliveryStatusDate = deliveryStatusDate;
        }

        public Integer getTemp() {
            return temp;
        }

        public void setTemp(Integer temp) {
            this.temp = temp;
        }

        public Object getPodImage() {
            return podImage;
        }

        public void setPodImage(Object podImage) {
            this.podImage = podImage;
        }

        public Object getExpectedPickupDate() {
            return expectedPickupDate;
        }

        public void setExpectedPickupDate(Object expectedPickupDate) {
            this.expectedPickupDate = expectedPickupDate;
        }

        public Object getFutureDeliveryDate() {
            return futureDeliveryDate;
        }

        public void setFutureDeliveryDate(Object futureDeliveryDate) {
            this.futureDeliveryDate = futureDeliveryDate;
        }

        public Object getAssetsCollected() {
            return assetsCollected;
        }

        public void setAssetsCollected(Object assetsCollected) {
            this.assetsCollected = assetsCollected;
        }

        public String getNewCategory() {
            return newCategory;
        }

        public void setNewCategory(String newCategory) {
            this.newCategory = newCategory;
        }
    }


}