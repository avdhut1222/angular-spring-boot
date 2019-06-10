import {CustomerAccount} from "./customer-account";
import {Contact} from "./contact";

export interface OrderDetail {
  orderNumber: string;
  customerAccount: CustomerAccount;
  activityIndicator: string;
  btn: string;
  organizationName: string;
  desiredDueDate: string;
  serviceOrderDate: string;
  orderedBy: string;
  orderedByTn: string;
  project: string;
  relatedPon: string;
  supplementTypeText: string;
  pon: string;
  contact: Contact;
  primaryBilling: string;
  assignedProvPlan: string;
}
