import {Component, Input, OnInit} from '@angular/core';
import {ConnectionHierarchyModel} from "../../../../domain/connection-hierarchy-model";

@Component({
    selector: 'app-connection-hierarchy-node',
    templateUrl: './connection-hierarchy-node.component.html',
    styleUrls: ['./connection-hierarchy-node.component.scss']
})
export class ConnectionHierarchyNodeComponent implements OnInit {

    @Input() node: ConnectionHierarchyModel;
    toggle: boolean;

    constructor() {
    }

    ngOnInit() {
    }

    toggleNode(){
        this.toggle = !this.toggle;
    }

}
